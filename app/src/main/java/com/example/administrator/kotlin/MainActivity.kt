package com.example.administrator.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.administrator.kotlin.domain.RequestForecastCommod
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    /*    var i: Int = 7
        var a: Double = i.toDouble()
        val s = "study"
        val c = s[1]
        val f1 = Forecast(Date(),22.0f,"热")
        val f2 = f1.copy(temprature = 27.4f)
        val (date,temprature,detail) = f1*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        textView.text = "hello kotlin1"
        val recyclerView: RecyclerView = find(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ForecastListadapter(items)
/*        for (c in s) {
            print(s)
        }*/
        async {
            //            Request("http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22").run()
            val result = RequestForecastCommod("94043").excute()
            uiThread {
                /*             recyclerView.adapter = ForecastListadapter(result,
                                     object : ForecastListadapter.OnItemClickListener {
                                         override fun invoke(forecast: Forecast) {
                                             toast(forecast.iconUrl)
                                         }
                                     }
                             )*/

//                recyclerView.adapter = ForecastListadapter(result) { forecast -> toast(forecast.iconUrl) }
                //后面的函数只接受一个参数可以使用it代替左边的参数
                recyclerView.adapter = ForecastListadapter(result) { toast(it.iconUrl) }
            }
        }
    }


}
