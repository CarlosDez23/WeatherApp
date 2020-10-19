package com.example.weatherapp.domain.mappers

import com.example.weatherapp.data.ForecastResult
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper {

    fun convertFromDataModel (forecast: ForecastResult): ForecastList =
        ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))


    private fun convertForecastListToDomain(list: List<com.example.weatherapp.data.Forecast>) : List<Forecast>{
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: com.example.weatherapp.data.Forecast): Forecast{
        return Forecast (convertDate(forecast.dt), forecast.weather[0].description,
            forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }


    private fun convertDate(date:Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}