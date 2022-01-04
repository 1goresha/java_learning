package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*
import kotlinx.android.synthetic.main.activity_coin_detail.ivLogoCoin
import kotlinx.android.synthetic.main.activity_coin_detail.tvPrice
import kotlinx.android.synthetic.main.item_coin_info.*

class CoinDetailActivity : AppCompatActivity() {

    companion object{
        private const val EXTRA_FROM_SYMBOL = "EXTRA_FROM_SYMBOL"
        fun newIntent(context: Context, fromSymbols: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbols)
            return intent
        }
    }

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)){           //intent - это тот же getIntent, только в kotlin он является свойством с геттером и сеттером
            finish()
            return
        }
        val fromSymbols = intent.getStringExtra(EXTRA_FROM_SYMBOL)?:return
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailCoinInfo(fromSymbols).observe(this, Observer {
            Log.d("DETAIL_COIN_INFO", it.toString())
            val symbols = this.resources.getString(R.string.symbols_template)
            tvCurrency.text = String.format(symbols, it.fromSymbol, it.toSymbol)
            tvPrice.text = it.price
            tvPriceMinForDay.text = it.lowDay
            tvPriceMaxForDay.text = it.highDay
            tvLastMarket.text = it.lastMarket
            tvLastUpdate.text = it.getLastUpdatedTime()
            Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
        })
    }
}