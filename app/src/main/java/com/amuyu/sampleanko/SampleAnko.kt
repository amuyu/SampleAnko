package com.amuyu.sampleanko

import android.app.Application

import com.amuyu.logger.DefaultLogPrinter
import com.amuyu.logger.Logger


class SampleAnko : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogPrinter(DefaultLogPrinter(this))
    }
}
