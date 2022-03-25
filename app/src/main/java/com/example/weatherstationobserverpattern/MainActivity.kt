package com.example.weatherstationobserverpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherstationobserverpattern.model.Siberian
import com.example.weatherstationobserverpattern.model.Vietnamese
import com.example.weatherstationobserverpattern.model.WeatherStation

class MainActivity : AppCompatActivity() {
    private companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherStation = WeatherStation()
        weatherStation.add(Siberian(weatherStation))
        weatherStation.add(Vietnamese(weatherStation))

        weatherStation.updateWeather()
    }
}