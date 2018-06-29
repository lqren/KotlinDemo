package com.example.administrator.kotlin.domain.model

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin.domain
 * 日  期: 2018/6/25
 * 描  述:
 */
data class ForecastList(val city: String, val country: String, val dailyForcecast: List<Forecast>){
    operator fun get(position:Int) :Forecast = dailyForcecast[position]
    fun size():Int = dailyForcecast.size
}

data class Forecast(val data: String, val description: String, val high: Int, val low: Int,val iconUrl:String)