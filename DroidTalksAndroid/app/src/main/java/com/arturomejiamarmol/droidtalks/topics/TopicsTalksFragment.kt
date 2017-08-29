package com.arturomejiamarmol.droidtalks.topics

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Injection
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.talks.TalksDetailsActivity

class TopicsTalksFragment : Fragment(), TopicsContract.View, OnListFragmentInteractionListener {


   private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: TopicsContract.UserActionListener


    override fun showTopics(topics: List<Topic>) {
        recyclerView.adapter = TopicsAdapter(topics, this)

    }

    override fun showTalksOfThisTopic(topic: String) {
        val intent = TalksDetailsActivity.getIntentToPresentTopicTalks(topic, activity)
        startActivity(intent)

    }

    override fun onListFragmentInteraction(topic: String) {
        presenter.openTalksOfThisTopic(topic)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = TopicsPresenter(mTalkView = this,
                mTalksRepo = Injection.talksRepository,
                mTopicsRepo = Injection.topicsRepository)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.topics_fragment_list, container, false)
        recyclerView = view as RecyclerView
        presenter.loadTopics()

        return view
    }

    companion object {
        fun newInstance(): TopicsTalksFragment {
            return TopicsTalksFragment()
        }
    }


}

interface OnListFragmentInteractionListener {
    fun onListFragmentInteraction(topic: String)
}
