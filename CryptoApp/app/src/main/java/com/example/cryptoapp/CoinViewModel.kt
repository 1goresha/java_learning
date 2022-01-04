package com.example.cryptoapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.cryptoapp.api.ApiFactory
import com.example.cryptoapp.database.AppDatabase
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.example.cryptoapp.pojo.CoinPriceInfoRawData
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application): AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()

    val priceList = db.coinPriceInfoDao().getPriceList()           //из базы берем лист

    fun getDetailCoinInfo(fSym: String): LiveData<CoinPriceInfo>{
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)                            //из базы берем детальнцю инфу цены
    }

    init {
        loadData()
    }

    private fun loadData(){
        val disposable = ApiFactory.apiFactory.getTopCoinInfo(limit = 10)//забираем из инета CoinInfoListOfData
            .map{
                it.data.map { it.coinInfo?.name }.joinToString(",")
            }
            .flatMap {
                ApiFactory.apiFactory.getFullPriceInfoList(fSyms = it)
            }
            .map {
                getPriceListFromRawData(it)
            }
            .delaySubscription(10, TimeUnit.SECONDS)//задержка в 10 сек
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({                                        //success:
                Log.d("LOAD_DATA", it.toString())
                db.coinPriceInfoDao().insertPriceList(it)       //сохраняем наш лист в БД с заменой и затем в ModelView слушаем все изменения, произошедшие в этом листе, и реагируем на них
            },{                                                 //failure:
                Log.d("LOAD_DATA_ERROR", it.message.toString())
            })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRawData(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo>{   //парсим и конвертируем Json объект в ArrayLis<CoinPriceInfo>
        val result = arrayListOf<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonObject ?: return result
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