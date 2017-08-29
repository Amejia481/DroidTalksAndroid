package com.arturomejiamarmol.droidtalks.topicsdetails

import com.arturomejiamarmol.droidtalks.data.Callback
import com.arturomejiamarmol.droidtalks.talks.Talk
import com.arturomejiamarmol.droidtalks.data.TalksRepository

/**
 * Created by Arturo Mejia on 8/1/17.
 */
open class TopicsDetailsPresenter(private val talksRepo : TalksRepository, private val view: TopicsDetailsContract.View)  {

    fun showTalksByTopic(topic: String){

        talksRepo.getTalksByTopic(topic, Callback<List<Talk>>({
            data, error ->

            view.showTalks(data)

        }))
    }
}