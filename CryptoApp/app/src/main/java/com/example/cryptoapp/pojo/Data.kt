package com.example.cryptoapp.pojo

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("CoinInfo" ) var coinInfo : CoinInfo? = null,
//    @SerializedName("RAW"      ) var RAW      : RAW?      = RAW(),
//    @SerializedName("DISPLAY"  ) var DISPLAY  : DISPLAY?  = DISPLAY()

)