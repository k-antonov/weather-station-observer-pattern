package com.example.weatherstationobserverpattern.model

import android.util.Log

class Vietnamese(private var station: WeatherStation) : IObserver {
    private companion object {
        const val TAG = "Vietnamese"
    }

    override fun update() {
        when {
            station.degrees > 35 -> Log.d(TAG, "It's kind of warm in here, isn't it?")
            station.degrees in 20..34 -> Log.d(TAG, "Comfortable")
            station.degrees in 10..19 -> Log.d(TAG, "It's rather cool")
            station.degrees in 0..9 -> Log.d(TAG, "It's cold")
            station.degrees in -20..-1 -> Log.d(TAG, "I have to get warm soon...")
            station.degrees in -34..-21 -> Log.d(TAG, "Can't feel my legs...")
            station.degrees < -35 -> Log.d(TAG, "Freezing")
        }
    }

}