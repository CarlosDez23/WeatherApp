package com.example.weatherapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.adapters.ForecastListAdapter
import com.example.weatherapp.ejemploapi.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toast("Hola mundo")
        //initRecyclerView()
        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                 "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        doRequest(url)
    }


    private fun initRecyclerView(){
        /**
         * Find usando la librería Anko, sin usarla sería
         * val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
         */
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }

    /**
     * Creación de una función, entre paréntesis los
     * parámetros y el tipo de dato que son y después
     * el típico de dato que devuelve. Si no especificamos
     * un return value retornará Unit que es similar a void
     * en Java
     */
    fun add(x: Int, y: Int): Int{
        return x+y
    }

    /**
     * Podemos pasar valores por defecto a las funciones si
     * el parámetro que le mandamos no tiene valor
     * fun toast(message: String, length: Int = Toast.LENGTH_SHORT){
            Toast.makeText(this, message,length).show()
        }
     *
     *
     */

    /**
     * Función extensión, podemos añadir un nuevo comportamiento a
     * una clase. Esta función actuará como otro elemento de la clase
     * en nuestro proyecto
     */
    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, message, duration).show()
    }

    /**
     * Petición a una API utilizando Anko
     */
    fun doRequest(url:String){
        doAsync {
            Request(url).run()
            uiThread { toast("Request performed") }
        }
    }

    /**
     * Podemos copiar un objeto de una data class, e incluso
     * podemos modificar para que algunos valores sean iguales
     * y otros adaptados a nuestras necesidades
     */
    /*
    fun copyObjectFromDataClass(){
        val forecast = Forecast(Date(), 27.5f, "Shiny day")
        val forecast2 = forecast.copy(temperature = 30f)
    }

    /**
     * Mapeamos cada atributo en una variable en una sola instrucción
     */
    fun mappingObjectIntoVariables(){
        val forecast = Forecast(Date(), 27.5f, "Shiny day")
        val(date, temperature, details) = forecast

    }
    */

}
