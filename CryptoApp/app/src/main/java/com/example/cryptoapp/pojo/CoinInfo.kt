package com.example.cryptoapp.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


//Информация от криптовалюте
data class CoinInfo(

//    @SerializedName("Id") var id: String? = null,
    @SerializedName("Name") var name: String? = null,
//    @SerializedName("FullName") var fullName: String? = null,
//    @SerializedName("ImageUrl") var imageUrl: String? = null
)