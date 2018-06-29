package com.example.administrator.kotlin

import android.content.Context
import android.widget.Toast

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin
 * 日  期: 2018/6/21
 * 描  述:
 */
open class Test{
    open fun Context.toast1(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }
}