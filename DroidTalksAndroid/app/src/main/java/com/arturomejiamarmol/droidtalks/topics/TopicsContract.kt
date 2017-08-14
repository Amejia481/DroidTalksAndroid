package com.arturomejiamarmol.droidtalks.topics

/**
 * Created by arturomejiamarmol on 7/13/17.
 */
interface TopicsContract {

    interface View{
        fun showTopics(topics: List<String>)
        fun showTalksOfThisTopic(topic: String)
    }

    interface UserActionListener{
        fun openTalksOfThisTopic(topic: String)
        fun loadTopics()
    }

}