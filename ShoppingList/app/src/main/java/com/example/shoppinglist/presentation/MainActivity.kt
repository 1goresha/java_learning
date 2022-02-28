package com.example.shoppinglist.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ShopItemFragment.OnEditingFinishedListener{

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter
    private var shopItemContainer: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shopItemContainer = findViewById(R.id.shop_item_container)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopListLD.observe(this) {            //activity и viewModel общаются друг с другом через liveData
            Log.d("SHOP_ITEM", it.toString())
//            shopListAdapter.shopList = it                      //лист в адаптере обновляется здесь, у него вызывется сеттер
            shopListAdapter.submitList(it)                      //лист в адаптере обновляется здесь, у него вызывется сеттер
        }
        val addButton = findViewById<FloatingActionButton>(R.id.button_add_shop_item)
        addButton.setOnClickListener {
            if (isOnePaneMode()) {
                val intent = ShopItemActivity.newIntentAddItem(applicationContext)
                startActivity(intent)
            } else {
                launchFragment(ShopItemFragment.newInstanceAddItem())
            }
        }
    }

    private fun isOnePaneMode(): Boolean {
        return shopItemContainer == null
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()           //удаляет старый фрагмент из BackStack
        supportFragmentManager.beginTransaction()
//            .add(R.id.shop_item_container, fragment)
            .replace(
                R.id.shop_item_container,
                fragment
            )        //лучше использовать replace за место add
            .addToBackStack(null)               //добавляет фрагмент в BackStack
            .commit()
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        shopListAdapter = ShopListAdapter()
        with(rvShopList) {
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.DISABLED,
                ShopListAdapter.POOL_MAX_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                ShopListAdapter.ENABLED,
                ShopListAdapter.POOL_MAX_SIZE
            )
        }
        setupLongClickListener()
        setupClickListener()
        setupItemSwipeListener(rvShopList)
    }

    private fun setupItemSwipeListener(rvShopList: RecyclerView) {
        val itemTouchCallBack = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val shopItem = shopListAdapter.shopList[viewHolder.adapterPosition]
                val shopItem = shopListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteShopItem(shopItem)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallBack)
        itemTouchHelper.attachToRecyclerView(rvShopList)
    }

    private fun setupClickListener() {
        shopListAdapter.onShopItemClickListener = {
            if (isOnePaneMode()) {
                val intent = ShopItemActivity.newIntentEditItem(applicationContext, it.id)
                startActivity(intent)
            } else {
                launchFragment(ShopItemFragment.newInstanceEditItem(it.id))
            }
        }
    }

    private fun setupLongClickListener() {
        shopListAdapter.onShopItemLongClickListener = {
            viewModel.changeEnabledState(it)
        }
    }

    private fun goToEditActivity(shopItem: ShopItem?) {
        val editIntent = Intent(this, ShopItemActivity::class.java)
        if (shopItem == null) return
        startActivity(editIntent)
    }

    override fun onEditingFinished() {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        supportFragmentManager.popBackStack()
    }
}