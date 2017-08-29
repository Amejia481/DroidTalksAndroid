package com.arturomejiamarmol.droidtalks.data.firebase

import com.arturomejiamarmol.droidtalks.creators.Creator
import com.arturomejiamarmol.droidtalks.creators.CreatorsRepository
import com.arturomejiamarmol.droidtalks.data.Callback
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Arturo Mejia on 8/17/17.
 */
class CreatorsFirebaseRepository: CreatorsRepository {

    private val firebaseBD = FirebaseDatabase.getInstance()

    init {
        firebaseBD.setPersistenceEnabled(true)
    }
    override fun getAllCreators(callback: Callback<List<Creator>>) {
        val myRef = firebaseBD.getReference(NODE_CREATORS_TALKS)

            myRef.addValueEventListener(object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {


                    val creators = dataSnapshot.children.map {

                        val creator = it.getValue<Creator>(Creator::class.java)
                        creator
                    }.sortedBy { it?.name }

                    callback.onFinish(creators as List<Creator>?, null)
                }

            })




    }

}