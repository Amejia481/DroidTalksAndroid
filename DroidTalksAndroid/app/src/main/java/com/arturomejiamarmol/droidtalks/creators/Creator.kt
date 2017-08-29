package com.arturomejiamarmol.droidtalks.creators

import com.arturomejiamarmol.droidtalks.talks.Talk
import com.google.firebase.database.PropertyName

/**
 * Created by Arturo Mejia on 8/17/17.
 */
class  Creator() {

    lateinit var id: String
    lateinit var name: String
    var talks = arrayListOf<Talk>()

    @set:PropertyName("resourcesCout")
    @get:PropertyName("resourcesCout")
    var count = 0
    var twitter = ""

    constructor(id: String, name: String, twitter: String,count: Int) : this() {
        this.id = id
        this.name = name
        this.twitter = twitter
        this.count = count
    }
}