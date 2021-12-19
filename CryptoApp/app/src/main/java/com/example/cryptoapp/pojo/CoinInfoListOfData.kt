package com.example.cryptoapp.pojo

import com.google.gson.annotations.SerializedName


//объект Json, который придет к нам в первую очередь и с которым мы будем затем работать(парсить)
data class CoinInfoListOfData(

    @SerializedName("Data") var data: List<Data> = arrayListOf()    //забираем только массив Data

    )