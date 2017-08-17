package com.arturomejiamarmol.droidtalks.events

/**
 * Created by Arturo Mejia on 8/17/17.
 */
class Event() {
    lateinit var id: String
    lateinit var name: String
    lateinit var versions: List<EventVersion>

    constructor(id: String, name: String, versions: List<EventVersion>) : this() {
        this.id = id
        this.name = name
        this.versions = versions
    }
}

class EventVersion() {
    lateinit var name: String
    lateinit var videoURL: String

    constructor(name: String, videoURL: String) : this() {
        this.name = name
        this.videoURL = videoURL
    }
}