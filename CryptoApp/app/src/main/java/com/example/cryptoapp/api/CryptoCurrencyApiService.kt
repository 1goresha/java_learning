package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinInfoListOfData
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCurrencyApiService {

    companion object{
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val API = "5e93c9b6b5e258c364c65560dc8ef28decf6d5d5de78a26b3a775a09d421941d"
        private const val CURRENCY = "USD"
    }

    @GET("top/totalvolfull")// взять первые 10 криптовалют
    fun getTopCoinInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey:String = API,
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym:String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")// взять полную информацию о денежной валюте по конкретной криптовалюте,
    fun getFullPriceInfoList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY
    ): Single<CoinPriceInfoRawData>
}