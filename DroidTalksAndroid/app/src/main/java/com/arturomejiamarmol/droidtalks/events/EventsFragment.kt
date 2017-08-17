package com.arturomejiamarmol.droidtalks.events

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
import com.arturomejiamarmol.droidtalks.data.ui.fromHtml
import com.arturomejiamarmol.droidtalks.data.ui.getLinkFromTemplate
import com.arturomejiamarmol.droidtalks.data.ui.getLinkFromTemplateHTML
import com.arturomejiamarmol.droidtalks.ui.tools.getMatColor

/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class EventsFragment : Fragment(), EventsContract.View, OnListFragmentInteractionListener {


    lateinit var recyclerView: RecyclerView
    private val presenter = EventsPresenter(this, Injection.eventsRepository)


    override fun showEvents(events: List<Event>) {
        recyclerView.adapter = EventsAdapter(events, this)
    }

    override fun onListFragmentInteraction(topic: String) {
        TODO("ADD Click Event")
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.events_fragment_list, container, false)
        recyclerView = view as RecyclerView
        presenter.loadEvents()

        return view
    }

    companion object {

        fun newInstance(): EventsFragment {
            val fragment = EventsFragment()
            return fragment
        }
    }


}

interface OnListFragmentInteractionListener {
    fun onListFragmentInteraction(topic: String)
}

class EventsAdapter(private val events: List<Event>, private val mListener: OnListFragmentInteractionListener) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.event_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]

        val context = holder.mTitle.context

        holder.mTitle.text = event.name

        holder.mContent.text =
                fromHtml(event.versions.joinToString(separator = "<br/><br/>") {
                    getLinkFromTemplate(it.videoURL, it.name, context)
                })

        holder.mContent.movementMethod = LinkMovementMethod.getInstance()


        holder.mView.setOnClickListener {
            mListener.onListFragmentInteraction(holder.mTitle.text.toString())
        }
    }

    override fun getItemCount(): Int = events.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTitle: TextView = mView.findViewById<TextView>(R.id.event_title)
        val mContent: TextView = mView.findViewById<TextView>(R.id.event_content)
    }
}
