package com.arturomejiamarmol.droidtalks.data

/**
 * Created by arturomejiamarmol on 6/27/17.
 */
interface TopicsRepository {
    fun getAllTopics(callback: CallBack<List<Topic>>): Unit

}