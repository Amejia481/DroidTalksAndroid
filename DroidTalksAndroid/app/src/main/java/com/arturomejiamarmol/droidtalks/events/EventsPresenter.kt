package com.arturomejiamarmol.droidtalks.events

import com.arturomejiamarmol.droidtalks.data.Callback

/**
 * Created by Arturo Mejia on 8/17/17.
 */
open class EventsPresenter(private val view: EventsContract.View,
                           private val repository: EventsRepository) : EventsContract.UserActionListener {

    override fun loadEvents() {
        repository.getAllEvents(Callback { data, _ ->
            view.showEvents(data)
        })
    }
}