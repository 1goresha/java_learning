package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    companion object {
        const val ENABLED = 1
        const val DISABLED = 0
        const val POOL_MAX_SIZE = 15
    }

//    var shopList = listOf<ShopItem>()
//        set(value) {
//            val callback = ShopListDiffCallback(shopList, value)
//            val diffResult = DiffUtil.calculateDiff(callback)
//            diffResult.dispatchUpdatesTo(this)
//            field = value
////            notifyDataSetChanged()
//        }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    //нужен для того, чтобы не использовать постоянно ресурсозатратный метод onViewById,
    // а использовать его только необходимое кол-во раз в методе onCreateViewHolder()
//    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//        val tvName = view.findViewById<TextView>(R.id.tv_name)
//        val tvCount = view.findViewById<TextView>(R.id.tv_count)
//    }

    //создаем нужное количество элементов для корректного отображения на экране, плюс еще немного
    // сверху и снизу за пределами экрана, чтобы при прокрутке не было лагов
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            ENABLED -> R.layout.item_shop_enabled
            DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("unknown view type: $viewType")
        }
        val view =
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    //устанавливаем необходимые значения в уже созданные View при помощи метода onCreateViewHolder()
    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
//        val shopItem = shopList[position]
        val shopItem = getItem(position)
        with(holder) {

            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            view.setOnLongClickListener {
                onShopItemLongClickListener?.invoke(shopItem)
                true
            }
            view.setOnClickListener {
                onShopItemClickListener?.invoke(shopItem)
            }
        }
    }

//    override fun getItemCount(): Int {
//        return shopList.size
//    }

    override fun getItemViewType(position: Int): Int {
//        val shopItem = shopList[position]
        val shopItem = getItem(position)
        val viewType = if (shopItem.enabled) {
            ENABLED
        } else {
            DISABLED
        }
        return viewType
    }
}