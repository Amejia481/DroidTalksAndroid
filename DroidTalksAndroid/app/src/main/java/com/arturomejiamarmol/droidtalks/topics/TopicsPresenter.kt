package com.arturomejiamarmol.droidtalks.topics

import com.arturomejiamarmol.droidtalks.data.CallBack
import com.arturomejiamarmol.droidtalks.data.TalksRepository
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.data.TopicsRepository

/**
 * Created by Arturo Mejia on 7/13/17.
 */
open class TopicsPresenter(var mTalkView: TopicsContract.View, var mTopicsRepo: TopicsRepository, var mTalksRepo: TalksRepository) : TopicsContract.UserActionListener {


    override fun loadTopics() {
        mTopicsRepo.getAllTopics(CallBack<List<Topic>> {
            data, error ->

            mTalkView.showTopics(data)
        })

    }


    override fun openTalksOfThisTopic(topic: String) {
        mTalkView.showTalksOfThisTopic(topic)
    }

}