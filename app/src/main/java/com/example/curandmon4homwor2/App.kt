package com.example.curandmon4homwor2

import android.app.Application
import com.example.curandmon4homwor2.utills.SheredPreference

class App:Application() {

    override fun onCreate() {
        super.onCreate()
    val sheredPreferenc = SheredPreference()
        sheredPreferenc.unit(this)
    }

}