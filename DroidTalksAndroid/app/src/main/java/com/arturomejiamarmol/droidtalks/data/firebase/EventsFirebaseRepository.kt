package com.arturomejiamarmol.droidtalks.data.firebase

import com.arturomejiamarmol.droidtalks.data.Callback
import com.arturomejiamarmol.droidtalks.data.Talk
import com.arturomejiamarmol.droidtalks.events.Event
import com.arturomejiamarmol.droidtalks.events.EventsRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Arturo Mejia on 8/17/17.
 */
class EventsFirebaseRepository : EventsRepository {

    private val firebaseBD = FirebaseDatabase.getInstance()

    init {
        firebaseBD.setPersistenceEnabled(true)
    }

    override fun getAllEvents(callback: Callback<List<Event>>) {
        val myRef = firebaseBD.getReference(NODE_EVENTS)

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val events = dataSnapshot.children.map {

                    it.getValue<Event>(Event::class.java)
                }.sortedBy { it?.name }


                callback.onFinish(events as List<Event>?, null)
            }

        })
    }
}