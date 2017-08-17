package com.arturomejiamarmol.droidtalks.data

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

class Topic() {

    lateinit var id: String
    lateinit var name: String
    var resourcesCount = 0


    constructor(id: String, name: String, resourcesCount: Int) : this() {
        this.id = id
        this.name = name
        this.resourcesCount = resourcesCount
    }
}