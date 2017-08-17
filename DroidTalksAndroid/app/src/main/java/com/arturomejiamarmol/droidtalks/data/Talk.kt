package com.arturomejiamarmol.droidtalks.data

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

class Talk{

    //lateinit var id: String
    lateinit var name: String
    lateinit var video: String
     var slides: String = ""
    lateinit var speakers: List<Speaker>
    lateinit var topic: String
    lateinit var type: String

}