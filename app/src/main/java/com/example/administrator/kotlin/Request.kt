package com.example.administrator.kotlin

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin
 * 日  期: 2018/6/22
 * 描  述:
 */
open class Request(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }
    fun run(): ResponseResult {
        val forecastJsonStr = URL(COMPLETE_URL+zipCode).readText()
        Log.d(javaClass.simpleName, forecastJsonStr + "================================================")
        return Gson().fromJson(forecastJsonStr, ResponseResult::class.java)
    }
}