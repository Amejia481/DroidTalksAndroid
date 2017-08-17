package com.arturomejiamarmol.droidtalks.topicsdetails

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Speaker
import com.arturomejiamarmol.droidtalks.data.Talk
import com.arturomejiamarmol.droidtalks.data.ui.fromHtml
import com.arturomejiamarmol.droidtalks.data.ui.getLinkFromTemplate
import com.arturomejiamarmol.droidtalks.data.ui.getLinkFromTemplateHTML
import com.arturomejiamarmol.droidtalks.ui.tools.getMatColor


class TalksDetailsAdapter(private val talks: List<Talk>) : RecyclerView.Adapter<TalksDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.talks_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val resource = talks[position]
        val authors = resource.speakers
        val context = holder.mName.context

        holder.mName.text = getLinkFromTemplateHTML(resource.video, resource.name, context)

        holder.mAuthors.text = speakerToLinks(authors, context) //getLinkFromTemplate("http://www.google.com","Google",context)
        holder.mResources.text = getLinkFromTemplateHTML(resource.slides, context.getString(R.string.slides), context)

        holder.mName.movementMethod = LinkMovementMethod.getInstance()
        holder.mAuthors.movementMethod = LinkMovementMethod.getInstance()
        holder.mResources.movementMethod = LinkMovementMethod.getInstance()

        holder.mView.setOnClickListener({
            TODO("OPEN LINK")
        })

    }

    override fun getItemCount(): Int {
        return talks.size
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mName: TextView = mView.findViewById<TextView>(R.id.name)
        val mAuthors: TextView = mView.findViewById<TextView>(R.id.authors)
        val mResources: TextView = mView.findViewById<TextView>(R.id.resources)


        override fun toString(): String {
            return super.toString() + " '"
        }
    }

    private fun speakerToLinks(list: List<Speaker>, context: Context): CharSequence {

        return fromHtml(list.joinToString(separator = ",") {

            getLinkFromTemplate(it.twitter, it.name, context)

        })

    }


}
