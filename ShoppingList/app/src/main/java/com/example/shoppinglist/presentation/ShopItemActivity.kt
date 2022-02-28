package com.example.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem
import java.lang.RuntimeException

class ShopItemActivity : AppCompatActivity(), ShopItemFragment.OnEditingFinishedListener {

    //    private lateinit var viewModel: ShopItemViewModel
//
//    private lateinit var tilName: TextInputLayout
//    private lateinit var tilCount: TextInputLayout
//    private lateinit var tietName: TextInputEditText
//    private lateinit var tietCount: TextInputEditText
//    private lateinit var btnSave: Button
//
    private var screenMode = MODE_UNKNOWN
    private var shopItemId = ShopItem.UNDEFINED_ID

    companion object {
        val TAG = ShopItemActivity::class.java.simpleName

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "id"

        private const val MODE_ADD = "mode_add"
        private const val MODE_EDIT = "mode_edit"

        private const val MODE_UNKNOWN = ""

        //статические фабричные методы:
        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, shopItemId: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, shopItemId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)

        parseIntent()
//        viewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
//        initViews()
//        addTextChangeListener()
        if (savedInstanceState == null) launchRightMode()           //если activity создалась впервые, то fragment создается и добавляется единожды     (на самом деле работает и без проверки отлично, лишнего fragment не создается)
        launchRightMode()
//        observeViewModels()
    }

    //    private fun observeViewModels() {
//        viewModel.errorInputName.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_name)
//            } else {
//                null
//            }
//            tietName.error = message
//        }
//        viewModel.errorInputCount.observe(this) {
//            val message = if (it) {
//                getString(R.string.error_input_count)
//            } else {
//                null
//            }
//            tietCount.error = message
//        }
//        viewModel.shouldCloseWindow.observe(this) {
//            finish()
//        }
//    }
//
    private fun launchRightMode() {
        val fragment = when (screenMode) {
            MODE_ADD -> ShopItemFragment.newInstanceAddItem()
            MODE_EDIT -> ShopItemFragment.newInstanceEditItem(shopItemId)
            else -> throw RuntimeException("Unknown screen mode $screenMode")
        }
        supportFragmentManager.beginTransaction()
//            .add(R.id.shop_item_container, fragment)            //при каждом повороте экрана будет добавлять фрагмент в BackStack, потому onCreate будет вызываться n = n + 1 раз
            .replace(
                R.id.shop_item_container,
                fragment
            )            //заменяет во BackStack старый фрагмент на новый
            .commit()
    }

    //
//    private fun addTextChangeListener() {
//        tietName.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                viewModel.resetErrorInputName()
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//            }
//        })
//        tietCount.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                viewModel.resetErrorInputCount()
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//            }
//        })
//    }
//
//    private fun launchAddMode() {
//        btnSave.setOnClickListener {
//            viewModel.addShopItem(tietName.text?.toString(), tietCount.text?.toString())
//        }
//    }
//
//    private fun launchEditMode() {
//        viewModel.getShopItem(shopItemId)
//        viewModel.shopItem.observe(this) {
//            tietName.setText(it.name)
//            tietCount.setText(it.count.toString())
//        }
//        btnSave.setOnClickListener {
//            viewModel.editShopItem(tietName.text?.toString(), tietCount.text?.toString())
//        }
//    }
//
//    private fun initViews() {
//        tilName = findViewById<TextInputLayout>(R.id.til_name)
//        tilCount = findViewById<TextInputLayout>(R.id.til_count)
//        tietName = findViewById<TextInputEditText>(R.id.tiet_name)
//        tietCount = findViewById<TextInputEditText>(R.id.tiet_count)
//        btnSave = findViewById<Button>(R.id.save_button)
//    }
//
    private fun parseIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) throw RuntimeException("Param screen mode is absent")
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_ADD && mode != MODE_EDIT) throw RuntimeException("Unknown screen mode $mode")
        screenMode = mode
        if (mode == MODE_EDIT) {
            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) throw RuntimeException("Param shop item id is absent")
            val itemId = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, ShopItem.UNDEFINED_ID)
            shopItemId = itemId
        }
    }

    override fun onEditingFinished() {
        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        supportFragmentManager.popBackStack()
    }
}