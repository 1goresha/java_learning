package com.example.cryptoapp.pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName


//Json объект, который получаем при запросе каких то определенных криптовалют, конвертированных в какую то определунную денежную валюту
data class CoinPriceInfoRawData(

    @SerializedName("RAW") var coinPriceInfoJsonObject: JsonObject? = null

)