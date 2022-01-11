package com.example.shoppinglist.domain

data class ShopItem(

    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID           //сделано для генерации id, поставленно в конец , потому что считается, что обязательные поля должны быть в начале, а не обязательные в конце
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}
