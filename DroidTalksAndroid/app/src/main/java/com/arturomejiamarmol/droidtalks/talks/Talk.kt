package com.arturomejiamarmol.droidtalks.talks

import com.arturomejiamarmol.droidtalks.data.Speaker
import com.google.firebase.database.Exclude
import org.parceler.Parcel

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

@Parcel
class Talk{
    @Exclude
    @get:Exclude
    @set:Exclude
    lateinit var id: String
    lateinit var name: String
    lateinit var video: String
     var slides: String = ""
    lateinit var speakers: List<Speaker>
    lateinit var topic: String
    lateinit var type: String

}