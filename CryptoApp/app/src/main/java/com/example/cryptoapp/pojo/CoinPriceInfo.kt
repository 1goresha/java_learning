package com.example.cryptoapp.pojo

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptoapp.api.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.utils.convertTimestampToTime
import com.google.gson.annotations.SerializedName


//Информация о денежной валюте, в которую была проконвертирована криатовалюта
@Entity(tableName = "full_price_list")
data class CoinPriceInfo (

    @PrimaryKey
    @NonNull
    @SerializedName("FROMSYMBOL"              ) var fromSymbol              : String,
    @SerializedName("TOSYMBOL"                ) var toSymbol                : String? = null,
    @SerializedName("MARKET"                  ) var market                  : String? = null,
    @SerializedName("PRICE"                   ) var price                   : String? = null,
    @SerializedName("LASTUPDATE"              ) var lastUpdate              : Long? = null,
    @SerializedName("LASTVOLUME"              ) var lastVolume              : String? = null,
    @SerializedName("LASTVOLUMETO"            ) var lastVolumeTo            : String? = null,
    @SerializedName("LASTTRADEID"             ) var lastTradeId             : String? = null,
    @SerializedName("VOLUMEDAY"               ) var volumeDay               : String? = null,
    @SerializedName("VOLUMEDAYTO"             ) var volumeDayTo             : String? = null,
    @SerializedName("VOLUME24HOUR"            ) var volume24Hour            : String? = null,
    @SerializedName("VOLUME24HOURTO"          ) var volume24HourTo          : String? = null,
    @SerializedName("OPENDAY"                 ) var openDay                 : String? = null,
    @SerializedName("HIGHDAY"                 ) var highDay                 : String? = null,
    @SerializedName("LOWDAY"                  ) var lowDay                  : String? = null,
    @SerializedName("OPEN24HOUR"              ) var open24Hour              : String? = null,
    @SerializedName("HIGH24HOUR"              ) var high24Hour              : String? = null,
    @SerializedName("LOW24HOUR"               ) var low24Hour               : String? = null,
    @SerializedName("LASTMARKET"              ) var lastMarket              : String? = null,
    @SerializedName("VOLUMEHOUR"              ) var volumeHour              : String? = null,
    @SerializedName("VOLUMEHOURTO"            ) var volumeHourTo            : String? = null,
    @SerializedName("OPENHOUR"                ) var openHour                : String? = null,
    @SerializedName("HIGHHOUR"                ) var highHour                : String? = null,
    @SerializedName("LOWHOUR"                 ) var lowHour                 : String? = null,
//    @SerializedName("TOPTIERVOLUME24HOUR"     ) var TOPTIERVOLUME24HOUR     : String? = null,
//    @SerializedName("TOPTIERVOLUME24HOURTO"   ) var TOPTIERVOLUME24HOURTO   : String? = null,
//    @SerializedName("CHANGE24HOUR"            ) var CHANGE24HOUR            : String? = null,
//    @SerializedName("CHANGEPCT24HOUR"         ) var CHANGEPCT24HOUR         : String? = null,
//    @SerializedName("CHANGEDAY"               ) var CHANGEDAY               : String? = null,
//    @SerializedName("CHANGEPCTDAY"            ) var CHANGEPCTDAY            : String? = null,
//    @SerializedName("CHANGEHOUR"              ) var CHANGEHOUR              : String? = null,
//    @SerializedName("CHANGEPCTHOUR"           ) var CHANGEPCTHOUR           : String? = null,
//    @SerializedName("CONVERSIONTYPE"          ) var CONVERSIONTYPE          : String? = null,
//    @SerializedName("CONVERSIONSYMBOL"        ) var CONVERSIONSYMBOL        : String? = null,
//    @SerializedName("SUPPLY"                  ) var SUPPLY                  : String? = null,
//    @SerializedName("MKTCAP"                  ) var MKTCAP                  : String? = null,
//    @SerializedName("MKTCAPPENALTY"           ) var MKTCAPPENALTY           : String? = null,
//    @SerializedName("CIRCULATINGSUPPLY"       ) var CIRCULATINGSUPPLY       : String? = null,
//    @SerializedName("CIRCULATINGSUPPLYMKTCAP" ) var CIRCULATINGSUPPLYMKTCAP : String? = null,
//    @SerializedName("TOTALVOLUME24H"          ) var TOTALVOLUME24H          : String? = null,
//    @SerializedName("TOTALVOLUME24HTO"        ) var TOTALVOLUME24HTO        : String? = null,
//    @SerializedName("TOTALTOPTIERVOLUME24H"   ) var TOTALTOPTIERVOLUME24H   : String? = null,
//    @SerializedName("TOTALTOPTIERVOLUME24HTO" ) var TOTALTOPTIERVOLUME24HTO : String? = null,
    @SerializedName("IMAGEURL"                ) var imageUrl                : String? = null

) {
    fun getLastUpdatedTime(): String {
        return convertTimestampToTime(lastUpdate)
    }

    fun getFullImageUrl() :String {
        return BASE_IMAGE_URL + imageUrl
    }
}