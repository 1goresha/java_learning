package com.example.cryptoapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.api.ApiFactory
import com.example.cryptoapp.database.AppDatabase
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CoinViewModel(application: Application): AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    private val priceList = db.coinPriceInfoDao().getPriceList()

    fun loadData(){
        val disposable = ApiFactory.apiFactory.getTopCoinInfo(limit = 50)
            .map{
                it.data.map { it.coinInfo?.name }.joinToString(",")
            }
            .flatMap {
                ApiFactory.apiFactory.getFullPriceInfoList(fSyms = it)
            }
            .map {
                getPriceListFromRawData(it)
            }
            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("LOAD_DATA", it.toString())
                db.coinPriceInfoDao().insertPriceList(it)
            },{
                Log.d("LOAD_DATA_ERROR", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo>{
        val result = arrayListOf<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject
        if (jsonObject == null) return result
        val coinKeys = jsonObject.keySet()
        for (coinKey in coinKeys){
            val currencyObject = jsonObject.getAsJsonObject(coinKey)
            val currencyKeys = currencyObject.keySet()
            for (currencyKey in currencyKeys){
                val coinPriceInfo = Gson().fromJson(
                    currencyObject.getAsJsonObject(currencyKey),
                    CoinPriceInfo::class.java
                )
                result.add(coinPriceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}