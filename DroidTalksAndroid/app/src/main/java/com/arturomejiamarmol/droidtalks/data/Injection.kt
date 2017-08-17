package com.arturomejiamarmol.droidtalks.data

import com.arturomejiamarmol.droidtalks.data.firebase.EventsFirebaseRepository
import com.arturomejiamarmol.droidtalks.data.firebase.TalksFirebaseRepo
import com.arturomejiamarmol.droidtalks.data.firebase.TopicsFirebaseRepo

/**
 * Created by arturomejiamarmol on 7/14/17.
 */
object Injection {

    val topicsRepository = TopicsFirebaseRepo()

    val talksRepository = TalksFirebaseRepo()

    val eventsRepository = EventsFirebaseRepository()
}