package com.arturomejiamarmol.droidtalks.creators

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Injection
import com.arturomejiamarmol.droidtalks.inflate
import com.arturomejiamarmol.droidtalks.talks.TalksDetailsActivity
import com.arturomejiamarmol.droidtalks.ui.tools.getMatColor

class CreatorsFragment : Fragment(), CreatorsContract.View, OnListFragmentInteractionListener {

    private lateinit var recyclerView: RecyclerView
    private val presenter = CreatorsPresenter(this, Injection.creatorRepository)
    private lateinit var creators: List<Creator>

    override fun showCreators(creators: List<Creator>) {
        recyclerView.adapter = CreatorsAdapter(creators, this)
        this.creators = creators
    }

    override fun showCreatorDetails(creatorId: String,name:String) {
       val creatorTalks = creators.first {
         it.id.equals(creatorId,ignoreCase = true)
        }

        startActivity(TalksDetailsActivity.getIntentToPresentCreatorTalks(creatorTalks.talks,name, activity))
    }


    override fun onListFragmentInteraction(creatorId: String, name: String) {
        presenter.showCreatorDetails(creatorId,name)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.topics_fragment_list, container, false)
        recyclerView = view as RecyclerView
        presenter.loadCreators()

        return view
    }

    companion object {
        fun newInstance(): CreatorsFragment {
            return CreatorsFragment()
        }
    }


}

interface OnListFragmentInteractionListener {
    fun onListFragmentInteraction(creatorId: String,name:String)
}

class CreatorsAdapter(private val creators: List<Creator>, private val mListener: OnListFragmentInteractionListener) : RecyclerView.Adapter<CreatorsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.topics_item_list)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val creator = creators[position]

        val context = holder.mName.context

        holder.mName.text = creator.name
        holder.mName.tag = creator
        holder.mCount.text = if (creator.count >= 100) "99+" else creator.count.toString()

        holder.mCount.setBackgroundColor(getMatColor("500", context))


        holder.mCount.movementMethod = LinkMovementMethod.getInstance()


        holder.mView.setOnClickListener {
            var creator = holder.mName.tag as Creator
            mListener.onListFragmentInteraction(creator.id,creator.name)
        }
    }

    override fun getItemCount(): Int = creators.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mName: TextView = mView.findViewById<TextView>(R.id.topic)
        val mCount: TextView = mView.findViewById<TextView>(R.id.count)

    }
}

