package com.arturomejiamarmol.droidtalks

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Arturo Mejia on 8/19/17.
 */

fun ViewGroup.inflate(@LayoutRes layoutRes:Int): View{
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}