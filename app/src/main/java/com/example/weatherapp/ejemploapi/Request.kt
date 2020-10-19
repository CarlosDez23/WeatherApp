package com.example.weatherapp.ejemploapi

import java.net.URL

class Request (val url: String) {
    fun run(){
        val forecastJsonStr = URL(url).readText()
        println(forecastJsonStr)
    }
}