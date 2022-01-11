package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class ShopItemViewModel: ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)

    fun getShopItem(id: Int): ShopItem {
        return getShopItemUseCase.getShopItem(id)
    }

    fun addShopItem(inputName: String?, inputCount: String?){
        val name = parseName(inputName)
        val count = parseCount(inputCount)
//        addShopItemUseCase.addShopItem(shopItem)
    }

    fun editShopItemUseCase(shopItem: ShopItem){
        editShopItemUseCase.editShopItem(shopItem)
    }

    private fun parseName(name: String?): String{
        return name?.trim() ?: ""
    }

    private fun parseCount(count: String?): Int {
        return try {
            count?.trim()?.toInt() ?: 0
        }catch (e: Exception){
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        var result = true
        if (name.isBlank()){
            //TODO: show error input name
            result = false
        }
        if (count < 0){
            //TODO: show error input count
            result = false
        }
        return result
    }
}