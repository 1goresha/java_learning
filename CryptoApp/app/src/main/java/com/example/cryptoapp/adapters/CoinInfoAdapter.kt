package com.example.cryptoapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.pojo.CoinPriceInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    var coinPriceInfoList = listOf<CoinPriceInfo>()
        set(value) {            //сеттер для coinPriceInfoList
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener: OnCoinClickListener? = null

    inner class CoinInfoViewHolder(coinView: View) : RecyclerView.ViewHolder(coinView) {
        val ivLogoCoin = coinView.ivLogoCoin
        val tvSymbols = coinView.tvSymbols
        val tvPrice = coinView.tvPrice
        val tvLastUpdateTime = coinView.tvLastUpdateTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coinPriceInfo = coinPriceInfoList[position]
        with(holder) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdate = context.resources.getString(R.string.last_update)
            tvSymbols.text =
                String.format(symbolsTemplate, coinPriceInfo.fromSymbol, coinPriceInfo.toSymbol)
            tvPrice.text = coinPriceInfo.price
            tvLastUpdateTime.text = String.format(lastUpdate, coinPriceInfo.getLastUpdatedTime())
            Picasso.get().load(coinPriceInfo.getFullImageUrl()).into(ivLogoCoin)
            itemView.setOnClickListener {
                onCoinClickListener?.onCoinClick(coinPriceInfo)
            }
        }
    }

    override fun getItemCount() = coinPriceInfoList.size

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}