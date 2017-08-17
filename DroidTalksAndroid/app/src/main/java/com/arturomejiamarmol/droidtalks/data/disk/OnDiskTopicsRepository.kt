package com.arturomejiamarmol.droidtalks.data.disk

import android.content.Context
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Callback
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.data.TopicsRepository
import com.arturomejiamarmol.droidtalks.ui.tools.loadJSON
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by arturomejiamarmol on 6/27/17.
 */

class OnDiskTopicsRepository(var context: Context) : TopicsRepository {
    override fun getAllTopics(callback: Callback<List<Topic>>) {
        val listType = object : TypeToken<List<Topic>>() {}.type
        val listOfTopics: List<Topic> = Gson().fromJson(loadJSON(context, R.raw.topics), listType)
        callback.onFinish(listOfTopics, null)
    }

}