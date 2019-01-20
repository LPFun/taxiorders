package com.aleksdark.taxiapp

import android.app.Application
import com.aleksdark.taxiapp.repository.client.RetrofitClient.Companion.initRetrofitClient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initRetrofitClient()
    }
}