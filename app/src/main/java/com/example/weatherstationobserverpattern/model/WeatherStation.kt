package com.example.weatherstationobserverpattern.model

import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlin.random.Random

class WeatherStation : IObservable {
    private companion object {
        const val TAG = "WeatherStation"
        const val LOWEST_TEMP = -40
        const val HIGHEST_TEMP = 40
        const val STEP_RANGE = 7
    }

    override val observers: MutableList<IObserver> = mutableListOf()

    var degrees = 0
        private set(value) {
            field = value
            sendUpdateEvent()
        }

    fun updateWeather() {
        val step = Random.nextInt(-STEP_RANGE, STEP_RANGE)
        degrees = when {
            degrees + step > HIGHEST_TEMP -> HIGHEST_TEMP
            degrees + step < LOWEST_TEMP -> LOWEST_TEMP
            else -> degrees + step
        }

        Handler(Looper.myLooper()!!).postDelayed({
            updateWeather()
            Log.d(TAG, "Current degrees: $degrees")
        }, 2000)
    }
}