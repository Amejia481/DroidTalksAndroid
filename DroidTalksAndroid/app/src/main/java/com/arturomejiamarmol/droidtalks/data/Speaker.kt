package com.arturomejiamarmol.droidtalks.data

import org.parceler.Parcel

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

@Parcel
class Speaker() {

    var id: String =""
    lateinit var name: String
    var twitter: String = ""

    constructor(id: String, name: String, twitter: String):this() {
        this.id = id
        this.name = name
        this.twitter = twitter
    }
}
