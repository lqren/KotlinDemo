package com.example.administrator.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.administrator.kotlin.domain.model.Forecast
import com.example.administrator.kotlin.domain.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * 作  者: roqy
 * 包  名: com.example.administrator.kotlin
 * 日  期: 2018/6/21
 *
 * 描  述:
 */
class ForecastListadapter(val items: ForecastList, val itemViewClick: (Forecast)->Unit) : RecyclerView.Adapter<ForecastListadapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

/*        with(items.get(position)) {
            holder.textView.text = "$data-$description-$high-/$low"
        }*/
        holder.bindForecast(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemViewClick)
    }

    class ViewHolder(view: View, val itemClick: (Forecast)->Unit) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.get().load(forecast.iconUrl).into(iconView)
                dateView.text = forecast.data
                descriptionView.text = forecast.description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }

    }

/*    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }*/
}

