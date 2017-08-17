package com.arturomejiamarmol.droidtalks.events

/**
 * Created by Arturo Mejia on 8/17/17.
 */
interface EventsContract {

    interface View {
        fun showEvents(events: List<Event>)
    }

    interface UserActionListener {
        fun loadEvents()
    }

}