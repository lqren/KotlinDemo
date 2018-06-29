package com.example.administrator.kotlin

import com.example.administrator.kotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.example.administrator.kotlin.domain.model.Forecast as ModelForecast

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin
 * 日  期: 2018/6/25
 * 描  述:
 */
class ForecastDataMapper {
    fun converFromDataModel(forecast: ResponseResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

}