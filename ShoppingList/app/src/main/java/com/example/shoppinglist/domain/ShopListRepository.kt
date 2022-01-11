package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {          //бизнес логика

    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(id: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}