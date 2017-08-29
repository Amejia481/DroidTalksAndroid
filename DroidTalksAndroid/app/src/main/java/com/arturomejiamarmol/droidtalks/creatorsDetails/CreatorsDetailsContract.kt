package com.arturomejiamarmol.droidtalks.creatorsDetails

import com.arturomejiamarmol.droidtalks.talks.Talk

/**
 * Created by Arturo Mejia on 8/21/17.
 */
interface CreatorsDetailsContract {

    interface View{
        fun showCreatorDetails(talks:List<Talk>)
    }
    interface UserActionListener{
        fun loadCreatorDetails(talks:List<Talk>)
    }
}