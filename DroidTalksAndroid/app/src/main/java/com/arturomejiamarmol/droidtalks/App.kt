package com.arturomejiamarmol.droidtalks

import android.app.Application

/**
 * Created by arturomejiamarmol on 7/14/17.
 */
class App : Application() {
    companion object {
        @JvmStatic lateinit var context: App
    }

    init {
        context = this
    }
}