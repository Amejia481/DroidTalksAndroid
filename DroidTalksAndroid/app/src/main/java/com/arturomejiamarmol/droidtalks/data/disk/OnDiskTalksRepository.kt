package com.arturomejiamarmol.droidtalks.data.disk


import android.content.Context
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Callback
import com.arturomejiamarmol.droidtalks.talks.Talk
import com.arturomejiamarmol.droidtalks.data.TalksRepository
import com.arturomejiamarmol.droidtalks.ui.tools.loadJSON
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

class OnDiskTalksRepository(var context: Context) : TalksRepository {


    private val talksByTopic: Map<String, MutableList<Talk>> by lazy {
        val map = mutableMapOf<String, MutableList<Talk>>()

        talks.map {
            talk ->


            map[talk.topic].let {

                if(it == null){
                    map[talk.topic] =  mutableListOf(talk)
                }else{
                    it.add(talk)
                }
            }
        }

        map

    }

    private val talks: List<Talk> by lazy {

        val listType = object : TypeToken<List<Talk>>() {

        }.type

        Gson().fromJson<List<Talk>>(
                loadJSON(context, R.raw.talks), listType)
    }

    override fun getTalksByTopic(topic: String, callBack: Callback<List<Talk>>) {
        callBack.onFinish(talksByTopic[topic],null)
    }


    override fun getAll(callBack: Callback<List<Talk>>) {
        callBack.onFinish(talks, null)
    }


}
