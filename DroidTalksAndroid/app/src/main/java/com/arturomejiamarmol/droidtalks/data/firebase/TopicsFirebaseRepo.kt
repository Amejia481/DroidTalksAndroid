package com.arturomejiamarmol.droidtalks.data.firebase

import com.arturomejiamarmol.droidtalks.data.CallBack
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.data.TopicsRepository
import com.google.firebase.database.*

/**
 * Created by Arturo Mejia on 8/15/17.
 */
class TopicsFirebaseRepo : TopicsRepository {


    val firebaseBD = FirebaseDatabase.getInstance()

    init {
        firebaseBD.setPersistenceEnabled(true)
    }

    override fun getAllTopics(callback: CallBack<List<Topic>>) {

        val myRef = firebaseBD.getReference(NODE_TOPICS_TALKS).orderByValue()


        myRef.addValueEventListener(object : ValueEventListener {
            val topics = mutableListOf<Topic>()

            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot?) {

                val type = object : GenericTypeIndicator<Map<@JvmSuppressWildcards String, @JvmSuppressWildcards Topic>>() {}

                val values = dataSnapshot?.getValue(type)

                values?.forEach {

                    _, topic ->
                    topics.add(topic)
                }
                topics.sortBy {
                    it.name.toLowerCase()
                }

                callback.onFinish(topics, null)
            }

        })
    }
}