package com.arturomejiamarmol.droidtalks.creators

import com.arturomejiamarmol.droidtalks.data.Callback

/**
 * Created by Arturo Mejia on 8/17/17.
 */
interface CreatorsRepository {
    fun getAllCreators(callback: Callback<List<Creator>>)
}