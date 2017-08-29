package com.arturomejiamarmol.droidtalks.creators

/**
 * Created by Arturo Mejia on 8/17/17.
 */
interface CreatorsContract {
    interface View{
        fun showCreators(creators:List<Creator>)
        fun showCreatorDetails(creatorId: String,name:String)

    }
    interface UserActionListener{
        fun showCreatorDetails(creatorId: String,name:String)
        fun loadCreators()
    }

}