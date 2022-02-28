package com.example.shoppinglist.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.lang.RuntimeException

class ShopItemFragment : Fragment() {

    private lateinit var viewModel: ShopItemViewModel

    private lateinit var tilName: TextInputLayout
    private lateinit var tilCount: TextInputLayout
    private lateinit var tietName: TextInputEditText
    private lateinit var tietCount: TextInputEditText
    private lateinit var btnSave: Button

    private lateinit var onEditingFinishedListener: OnEditingFinishedListener

    private var screenMode: String = MODE_UNKNOWN
    private var shopItemId: Int = ShopItem.UNDEFINED_ID

    override fun onAttach(context: Context) {           //context является activity, к которой приклеплен fragment
        super.onAttach(context)
        if (context is OnEditingFinishedListener) {
            onEditingFinishedListener = context
        } else {
            throw RuntimeException("You have to implement OnEditingFinishedListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
        Log.i("ShopItemFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[ShopItemViewModel::class.java]
        initViews(view)
        addTextChangeListener()
        launchMode()
        observeViewModels()
    }

    companion object {
        val TAG = ShopItemActivity::class.java.simpleName

        private const val SCREEN_MODE = "extra_mode"
        private const val SHOP_ITEM_ID = "id"

        private const val MODE_ADD = "mode_add"
        private const val MODE_EDIT = "mode_edit"

        private const val MODE_UNKNOWN = ""

        //статические фабричные методы:

        fun newInstanceAddItem(): ShopItemFragment {
            return ShopItemFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_ADD)
                }
            }
        }

        fun newInstanceEditItem(shopItemId: Int): ShopItemFragment {
            return ShopItemFragment().apply {
                arguments = Bundle().apply {
                    putString(SCREEN_MODE, MODE_EDIT)
                    putInt(SHOP_ITEM_ID, shopItemId)
                }
            }
        }
    }

    interface OnEditingFinishedListener {           //interface, который будет реализоваться в activity, для показа сообщения сразу после добавления элемента
        fun onEditingFinished()
    }

    private fun observeViewModels() {
        viewModel.errorInputName.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_name)
            } else {
                null
            }
            tietName.error = message
        }
        viewModel.errorInputCount.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_count)
            } else {
                null
            }
            tietCount.error = message
        }
        viewModel.shouldCloseWindow.observe(viewLifecycleOwner) {
            activity?.onBackPressed()           //безопасный способ
//            requireActivity().onBackPressed()   //небезопасный способ
            onEditingFinishedListener.onEditingFinished()
        }
    }

    private fun launchMode() {
        when (screenMode) {
            MODE_ADD -> launchAddMode()
            MODE_EDIT -> launchEditMode()
        }
    }

    private fun addTextChangeListener() {
        tietName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputName()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        tietCount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.resetErrorInputCount()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun launchAddMode() {
        btnSave.setOnClickListener {
            viewModel.addShopItem(tietName.text?.toString(), tietCount.text?.toString())
        }
    }

    private fun launchEditMode() {
        viewModel.getShopItem(shopItemId)
        viewModel.shopItem.observe(viewLifecycleOwner) {
            tietName.setText(it.name)
            tietCount.setText(it.count.toString())
        }
        btnSave.setOnClickListener {
            viewModel.editShopItem(tietName.text?.toString(), tietCount.text?.toString())
        }
    }

    private fun initViews(view: View) {
        tilName = view.findViewById<TextInputLayout>(R.id.til_name)
        tilCount = view.findViewById<TextInputLayout>(R.id.til_count)
        tietName = view.findViewById<TextInputEditText>(R.id.tiet_name)
        tietCount = view.findViewById<TextInputEditText>(R.id.tiet_count)
        btnSave = view.findViewById<Button>(R.id.save_button)
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(SCREEN_MODE)) throw RuntimeException("Param screen mode is absent")
        val mode = args.getString(SCREEN_MODE)
        if (mode != MODE_ADD && mode != MODE_EDIT) throw RuntimeException("Unknown screen mode $mode")
        screenMode = mode
        if (mode == MODE_EDIT) {
            if (!args.containsKey(SHOP_ITEM_ID)) throw RuntimeException("Param shop item id is absent")
            val itemId = args.getInt(SHOP_ITEM_ID, ShopItem.UNDEFINED_ID)
            shopItemId = itemId
        }
    }
}