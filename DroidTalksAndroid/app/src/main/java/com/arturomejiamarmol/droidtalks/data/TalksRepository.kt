package com.arturomejiamarmol.droidtalks.data

import com.arturomejiamarmol.droidtalks.talks.Talk

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

interface TalksRepository {
    fun getAll(callBack: Callback<List<Talk>>)
    fun getTalksByTopic(topic: String, callBack: Callback<List<Talk>>)
}
