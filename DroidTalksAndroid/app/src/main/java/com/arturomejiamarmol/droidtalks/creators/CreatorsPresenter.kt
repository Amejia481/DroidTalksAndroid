package com.arturomejiamarmol.droidtalks.creators

import com.arturomejiamarmol.droidtalks.data.Callback

/**
 * Created by Arturo Mejia on 8/17/17.
 */
class CreatorsPresenter(private val view: CreatorsContract.View, private val repository: CreatorsRepository): CreatorsContract.UserActionListener {

    override fun showCreatorDetails(creatorId: String, name:String) {
            view.showCreatorDetails(creatorId,name)
    }

    override fun loadCreators() {
        repository.getAllCreators(Callback { data, error ->
            view.showCreators(data)
        })
    }


}