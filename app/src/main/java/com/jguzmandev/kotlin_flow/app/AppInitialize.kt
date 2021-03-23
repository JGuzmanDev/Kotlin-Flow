package com.jguzmandev.kotlin_flow.app

import android.app.Application

class AppInitialize : Application() {

    val injector by lazy { Injector(this) }

}