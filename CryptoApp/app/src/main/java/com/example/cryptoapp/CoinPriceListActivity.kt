package com.example.cryptoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.adapters.CoinInfoAdapter
import com.example.cryptoapp.pojo.CoinPriceInfo
import kotlinx.android.synthetic.main.activity_coin_price_list.*

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)

        val adapter = CoinInfoAdapter(this)
        rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        viewModel.loadData()      //теперь загрузка данных происходит в init
//        viewModel.priceList.observe(this, Observer {
//            Log.d("observe", it.toString())
//        })

        //реагируем на изменения List<CoinPriceInfo> и кидаем в адаптер измененный лист, где тот отображает снова уже обновленный лист
        viewModel.priceList.observe(this, Observer {
//            Log.d("observe", it.toString())
            adapter.coinPriceInfoList = it
            adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
                override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
//                    Log.d("onCoinClick", coinPriceInfo.fromSymbol)
                    val intent = CoinDetailActivity.newIntent(
                        this@CoinPriceListActivity,
                        coinPriceInfo.fromSymbol
                    )
                    startActivity(intent)
                }
            }
        })
    }
}