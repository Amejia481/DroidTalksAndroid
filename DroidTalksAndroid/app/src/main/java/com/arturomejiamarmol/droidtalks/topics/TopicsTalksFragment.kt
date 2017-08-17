package com.arturomejiamarmol.droidtalks.topics

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Injection
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.topicsdetails.TOPIC_NAME
import com.arturomejiamarmol.droidtalks.topicsdetails.TopicsDetailsActivity

/**
 * A fragment representing a list of Items.
 *
 *
 * Activities containing this fragment MUST implement the [OnListFragmentInteractionListener]
 * interface.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class TopicsTalksFragment : Fragment(), TopicsContract.View, OnListFragmentInteractionListener {


    lateinit var recyclerView: RecyclerView
    lateinit var presenter: TopicsContract.UserActionListener
    private var mColumnCount = 1


    override fun showTopics(topics: List<Topic>) {

        recyclerView.adapter = TopicsAdapter(topics, this)

    }

    override fun showTalksOfThisTopic(topic: String) {
        val intent =
                Intent(context, TopicsDetailsActivity::class.java)
                        .putExtra(TOPIC_NAME, topic)

        startActivity(intent)

    }

    override fun onListFragmentInteraction(topic: String) {
        presenter.openTalksOfThisTopic(topic)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments.getInt(ARG_COLUMN_COUNT)
        }

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

        // TODO: Customize parameter argument names
        private val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        fun newInstance(columnCount: Int): TopicsTalksFragment {
            val fragment = TopicsTalksFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }


}

interface OnListFragmentInteractionListener {
    fun onListFragmentInteraction(topic: String)
}
