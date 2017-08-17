package com.arturomejiamarmol.droidtalks.data.firebase

import com.arturomejiamarmol.droidtalks.data.Callback
import com.arturomejiamarmol.droidtalks.data.Talk
import com.arturomejiamarmol.droidtalks.data.TalksRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Arturo Mejia on 8/15/17.
 */
class TalksFirebaseRepo : TalksRepository {

    private val firebaseBD = FirebaseDatabase.getInstance()

    init {
        firebaseBD.setPersistenceEnabled(true)
    }


    override fun getAll(callBack: Callback<List<Talk>>) {
        val myRef = firebaseBD.getReference(NODE_TALKS)

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val talks = dataSnapshot.children.map {

                    it.getValue<Talk>(Talk::class.java)
                }

                callBack.onFinish(talks as List<Talk>?, null)
            }

        })


    }

    override fun getTalksByTopic(topic: String, callBack: Callback<List<Talk>>) {
        val myRef = firebaseBD.getReference(NODE_TALKS).orderByChild(NODE_TOPIC).equalTo(topic)

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val talks = dataSnapshot.children.map {
                    it.getValue<Talk>(Talk::class.java)
                }

                callBack.onFinish(talks as List<Talk>?, null)
            }

        })
    }
}