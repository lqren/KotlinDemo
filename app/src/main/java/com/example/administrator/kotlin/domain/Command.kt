package com.example.administrator.kotlin.domain

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin.domain
 * 日  期: 2018/6/25
 * 描  述:
 */
interface Command<T>{
    fun excute():T
}