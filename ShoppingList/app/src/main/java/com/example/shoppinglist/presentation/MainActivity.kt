package com.example.shoppinglist.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListAdapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopListLD.observe(this) {            //activity и viewModel общаются друг с другом через liveData
            Log.d("SHOP_ITEM", it.toString())
//            shopListAdapter.shopList = it                      //лист в адаптере обновляется здесь, у него вызывется сеттер
            shopListAdapter.submitList(it)                      //лист в адаптере обновляется здесь, у него вызывется сеттер
        }
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
        setupShopItemLongClickListener()
        setupShopItemClickListener()
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

    private fun setupShopItemClickListener() {
        shopListAdapter.onShopItemClickListener = {
            goToEditActivity(it)
            Log.d("SHOP_ITEM", it.toString())
        }
    }

    private fun setupShopItemLongClickListener() {
        shopListAdapter.onShopItemLongClickListener = {
            viewModel.changeEnabledState(it)
        }
    }

    private fun goToEditActivity(shopItem: ShopItem?) {
        val editIntent = Intent(this, ShopItemActivity::class.java)
        if (shopItem == null) return
        startActivity(editIntent)
    }
}