package com.arturomejiamarmol.droidtalks.topicsdetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Injection
import com.arturomejiamarmol.droidtalks.data.Talk


class TopicsDetailsActivity : AppCompatActivity(), TopicsDetailsContract.View {

     val presenter =  TopicsDetailsPresenter(Injection.talksRepository,this)
     lateinit var recyclerView : RecyclerView

    override fun showTalks(talks: List<Talk>) {
        title =  "$title (${talks.size})"
        recyclerView =  findViewById<RecyclerView>(R.id.talks)
        recyclerView.adapter = TalksDetailsAdapter(talks)

    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.topics_details_activity)



       intent.let {
           title = it.extras[TOPIC_NAME].toString()
           presenter.showTalksByTopic(title.toString())
       }



    }

}
