package com.arturomejiamarmol.droidtalks.topics

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Topic
import com.arturomejiamarmol.droidtalks.ui.tools.*

class TopicsAdapter(private val topics: List<Topic>, private val mListener: OnListFragmentInteractionListener) : RecyclerView.Adapter<TopicsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.topics_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topic = topics[position]

        holder.mTopic.text = topic.name
        holder.mCount.text = if (topic.resourcesCount >= 100) "99+" else topic.resourcesCount.toString()

        holder.mCount.setBackgroundColor(getMatColor("500", holder.mTopic.context))

        holder.mView.setOnClickListener {
            mListener.onListFragmentInteraction(holder.mTopic.text.toString())
        }
    }

    override fun getItemCount(): Int = topics.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTopic: TextView = mView.findViewById<TextView>(R.id.topic)
        val mCount: TextView = mView.findViewById<TextView>(R.id.count)
    }
}
