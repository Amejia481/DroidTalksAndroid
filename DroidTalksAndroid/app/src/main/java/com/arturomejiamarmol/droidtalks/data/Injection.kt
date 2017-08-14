package com.arturomejiamarmol.droidtalks.data

import com.arturomejiamarmol.droidtalks.App
import com.arturomejiamarmol.droidtalks.data.disk.OnDiskTalksRepository
import com.arturomejiamarmol.droidtalks.data.disk.OnDiskTopicsRepository

/**
 * Created by arturomejiamarmol on 7/14/17.
 */
object Injection {
    val topicsRepository: TopicsRepository
        get() = OnDiskTopicsRepository(App.context)

    val talksRepository: TalksRepository
        get() = OnDiskTalksRepository(App.context)
}