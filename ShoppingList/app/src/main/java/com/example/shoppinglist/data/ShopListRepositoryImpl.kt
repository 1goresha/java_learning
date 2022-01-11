package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl : ShopListRepository {

    private var shopListLD = MutableLiveData<List<ShopItem>>()            //MutableLiveData - это класс-наследник, который уже имплементировал LiveData, и мы его используем
    private var autoIncrementId = 0
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })

    init {
        for(i in 0 until 1000){
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItem(shopItem.id)
        shopList.remove(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find { it.id == id }
            ?: throw RuntimeException("Element with id = $id not found")           //подразумевается, что shopItem не может быть равным null, в случаии null он бросает ошибку
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {          //обновляем LiveData<List<ShopItem>>, чтобы можно было реагировать тем или иным образом на его изменения
        this.shopListLD.value = shopList.toList()          //возвращаем копию коллекции, потому что саму коллекцию возвращать не стоит, это противоречит принципу инкапсуляции
    }
}