package com.arturomejiamarmol.droidtalks.data.disk

import android.content.Context
import com.arturomejiamarmol.droidtalks.data.CallBack
import com.arturomejiamarmol.droidtalks.data.TopicsRepository
import com.arturomejiamarmol.droidtalks.ui.tools.loadJSON
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Talk

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList
import java.util.HashMap

/**
 * Created by arturomejiamarmol on 6/27/17.
 */

class OnDiskTopicsRepository(var context: Context) : TopicsRepository{
    override fun getMapTopicsTalks(topics: List<String>, talks: List<Talk>): Map<String, List<Talk>> {

        val topicsTalks = HashMap<String, List<Talk>>()

        for (talk in talks) {
            val actualTopic = talk.topic
            var talksByThisTopic: MutableList<Talk>?
            talksByThisTopic = topicsTalks.get(actualTopic) as MutableList<Talk>?

            if (talksByThisTopic == null) {
                talksByThisTopic = ArrayList<Talk>()
            }
            talksByThisTopic.add(talk)
            topicsTalks.put(talk.topic, talksByThisTopic)
        }
        return topicsTalks
    }


    override fun getAllTopics(callback: CallBack<List<String>>) {

        var listType  = object : TypeToken<List<String>>(){}.type
        var listOfTopics: List<String> = Gson().fromJson(loadJSON(context,R.raw.topics), listType)
        callback.onFinish(listOfTopics,null)
    }




}