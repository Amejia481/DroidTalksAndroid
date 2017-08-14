package com.arturomejiamarmol.droidtalks.data

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

interface TalksRepository {
    fun getAll(callBack: CallBack<List<Talk>>)
    fun getTalksByTopic(topic: String, callBack:CallBack<List<Talk>>)
}
