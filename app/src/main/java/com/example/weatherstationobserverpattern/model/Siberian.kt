package com.example.weatherstationobserverpattern.model

import android.util.Log

class Siberian(private var station: WeatherStation) : IObserver {
    private companion object {
        const val TAG = "Siberian"
    }

    override fun update() {
        when {
            station.degrees > 35 -> Log.d(TAG, "Feels like my skin is burning")
            station.degrees in 25..34 -> Log.d(TAG, "Hot")
            station.degrees in 16..24 -> Log.d(TAG, "Comfortable")
            station.degrees in -20..15 -> Log.d(TAG, "Acceptable")
            station.degrees in -34..-21 -> Log.d(TAG, "Feels cold")
            station.degrees < -35 -> Log.d(TAG, "Ivan, bring us some vodka!")
        }
    }
}