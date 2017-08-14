package com.arturomejiamarmol.droidtalks.topicsdetails

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.arturomejiamarmol.droidtalks.R
import com.arturomejiamarmol.droidtalks.data.Talk
import com.arturomejiamarmol.droidtalks.ui.tools.getMatColor
import android.text.Spanned
import com.arturomejiamarmol.droidtalks.data.Speaker


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



        holder.mName.setTextColor(getMatColor("900", holder.mView.context))

        holder.mName.text = getLinkFromTemplateHTML(resource.video,resource.name,context)

        holder.mAuthors.text = speakerToLinks(authors, context) //getLinkFromTemplate("http://www.google.com","Google",context)
        holder.mResources.text = getLinkFromTemplateHTML(resource.slides, context.getString(R.string.slides), context)

        holder.mName.movementMethod = LinkMovementMethod.getInstance()
        holder.mAuthors.movementMethod = LinkMovementMethod.getInstance()
        holder.mResources.movementMethod = LinkMovementMethod.getInstance()

        holder.mView.setOnClickListener({
            it?.let {
                TODO("OPEN LINK")
            }
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
            (name, twitter) ->

            getLinkFromTemplate(twitter, name, context)

        })

    }

    private fun getLinkFromTemplateHTML(href: String, text: String, context: Context) = fromHtml(context.getString(R.string.link_template, href, text))
    private fun getLinkFromTemplate(href: String, text: String, context: Context) = context.getString(R.string.link_template, href, text)


    @SuppressWarnings("deprecation")
    private fun fromHtml(html: String): Spanned {
        val result: Spanned
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            result = Html.fromHtml(html)
        }
        return result
    }
}
