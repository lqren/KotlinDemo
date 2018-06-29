package com.example.administrator.kotlin.domain

import com.example.administrator.kotlin.ForecastDataMapper
import com.example.administrator.kotlin.Request
import com.example.administrator.kotlin.domain.model.ForecastList

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin.domain
 * 日  期: 2018/6/25
 * 描  述:
 */
class RequestForecastCommod(val zipCode: String) : Command<ForecastList> {
    override fun excute(): ForecastList {
        val request = Request(zipCode)
        return ForecastDataMapper().converFromDataModel(request.run())
    }

}