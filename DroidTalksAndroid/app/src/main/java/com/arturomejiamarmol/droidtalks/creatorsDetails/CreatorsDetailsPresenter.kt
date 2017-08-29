package com.arturomejiamarmol.droidtalks.creatorsDetails

import com.arturomejiamarmol.droidtalks.talks.Talk

/**
 * Created by Arturo Mejia on 8/21/17.
 */
class CreatorsDetailsPresenter(val view: CreatorsDetailsContract.View) : CreatorsDetailsContract.UserActionListener {
    override fun loadCreatorDetails(talks:List<Talk>) {
        view.showCreatorDetails(talks)

    }


}