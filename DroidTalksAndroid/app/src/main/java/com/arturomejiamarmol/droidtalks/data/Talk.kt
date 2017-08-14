package com.arturomejiamarmol.droidtalks.data

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

data class Talk(val id: Int, val name: String,
                val video: String, val slides: String ="",
                val speakers: List<Speaker> = listOf(),
                val topic: String)
