package com.arturomejiamarmol.droidtalks.talks

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.creatorsDetails.CreatorsDetailsContract
import com.arturomejiamarmol.droidtalks.creatorsDetails.CreatorsDetailsPresenter
import com.arturomejiamarmol.droidtalks.data.Injection
import com.arturomejiamarmol.droidtalks.topicsdetails.TopicsDetailsContract
import com.arturomejiamarmol.droidtalks.topicsdetails.TopicsDetailsPresenter
import org.parceler.Parcels




class TalksDetailsActivity : AppCompatActivity(), TopicsDetailsContract.View, CreatorsDetailsContract.View {


   private val presenter = TopicsDetailsPresenter(Injection.talksRepository, this)
    private lateinit var recyclerView: RecyclerView

    private val creatorPresenter = CreatorsDetailsPresenter(this)

    override fun showCreatorDetails(talks: List<Talk>) {
        showTalks(talks)
    }

    override fun showTalks(talks: List<Talk>) {
        title = "$title (${talks.size})"
        recyclerView = findViewById<RecyclerView>(R.id.talks)
        recyclerView.adapter = TalksDetailsAdapter(talks)

    }

    companion object {
        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_TALKS_LIST = "KEY_TALKS_LIST"

        fun getIntentToPresentTopicTalks(topic: String, context: Context): Intent {
            return getIntent(context, title = topic, showTalksBy = ShowTalksBy.TOPIC)
        }

        fun getIntentToPresentCreatorTalks(talks: List<Talk>, creatorName:String, context: Context): Intent {
            return getIntent(context, talks, creatorName, ShowTalksBy.CREATOR)

        }

        private fun getIntent(context: Context, talks:List<Talk> = emptyList(), title:String, showTalksBy: ShowTalksBy): Intent {
            return Intent(context, TalksDetailsActivity::class.java).apply {

                putExtra(KEY_TITLE, title)

                if (!talks.isEmpty())
                    putExtra(KEY_TALKS_LIST, Parcels.wrap(talks))

                action = showTalksBy.action
            }

        }
    }


    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.topics_details_activity)


        intent.let {
            title = when (ShowTalksBy.fromString(it.action)) {
                ShowTalksBy.TOPIC -> {
                    val value  = it.extras[KEY_TITLE].toString()
                    presenter.showTalksByTopic(value)
                    value
                }

                ShowTalksBy.CREATOR -> {
                    val talks = Parcels.unwrap<List<Talk>>(intent.getParcelableExtra<Parcelable>(KEY_TALKS_LIST))

                    creatorPresenter.loadCreatorDetails(talks)
                    it.extras[KEY_TITLE].toString()

                }

            }

        }


    }

    private enum class ShowTalksBy(var action: String) {
        TOPIC("SHOW_TALKS_BY_TOPIC"), CREATOR("SHOW_TALKS_BY_CREATOR");

        companion object {
            fun fromString(key: String): ShowTalksBy {
                return ShowTalksBy.values().filter { it.action == key }.first()
            }
        }

    }

}
