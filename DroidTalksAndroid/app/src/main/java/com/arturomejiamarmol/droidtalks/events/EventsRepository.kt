package com.arturomejiamarmol.droidtalks.events

import com.arturomejiamarmol.droidtalks.data.Callback

/**
 * Created by Arturo Mejia on 8/17/17.
 */
interface EventsRepository {
    fun getAllEvents(callback: Callback<List<Event>>)
}