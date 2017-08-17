package com.arturomejiamarmol.droidtalks.topics

import com.arturomejiamarmol.droidtalks.data.Topic

/**
 * Created by arturomejiamarmol on 7/13/17.
 */
interface TopicsContract {

    interface View {
        fun showTopics(topics: List<Topic>)
        fun showTalksOfThisTopic(topic: String)
    }

    interface UserActionListener {
        fun openTalksOfThisTopic(topic: String)
        fun loadTopics()
    }

}