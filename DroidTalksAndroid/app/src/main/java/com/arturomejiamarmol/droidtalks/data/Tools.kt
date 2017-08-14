@file:JvmName("Utils")
package com.arturomejiamarmol.droidtalks.ui.tools

import android.content.Context
import android.graphics.Color.BLACK
import com.arturomejiamarmol.droidtalks.R
import java.io.IOException


/**
 * Created by arturomejiamarmol on 6/23/17.
 */
var  lastColor = 0

fun getMatColor(typeColor: String, context: Context): Int {

    var returnColor = BLACK
    val arrayId = context.resources.getIdentifier("mdcolor_" + typeColor, "array", context.packageName)

    if (arrayId != 0) {
        val colors = context.resources.obtainTypedArray(arrayId)

        do{
            val index = (Math.random() * colors.length()).toInt()
            returnColor = colors.getColor(index, BLACK)

        } while(lastColor == returnColor)
        lastColor = returnColor
        colors.recycle()

    }



    return returnColor
}


 fun loadJSON(context: Context, resource: Int ): String? {
    var json: String? = null
    try {
        val rawResource = context.resources.openRawResource(resource)
        val size = rawResource.available()
        val buffer = ByteArray(size)
        rawResource.read(buffer)
        rawResource.close()
        json =  String(buffer)
//UTF-8

    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }

    return json
}