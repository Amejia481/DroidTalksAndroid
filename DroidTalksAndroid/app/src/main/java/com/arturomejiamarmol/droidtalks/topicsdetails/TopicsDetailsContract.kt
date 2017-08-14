package com.arturomejiamarmol.droidtalks.topicsdetails

import com.arturomejiamarmol.droidtalks.data.Talk

/**
 * Created by Arturo Mejia on 8/1/17.
 */
interface TopicsDetailsContract {

    interface View{
        fun showTalks(talks: List<Talk>)

    }

    interface UserActionListener{

    }


}