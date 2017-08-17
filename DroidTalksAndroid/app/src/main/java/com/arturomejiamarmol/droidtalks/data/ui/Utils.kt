package com.arturomejiamarmol.droidtalks.data.ui

import android.content.Context
import android.text.Html
import android.text.Spanned
import com.arturomejiamarmol.droidtalks.R

/**
 * Created by Arturo Mejia on 8/17/17.
 */

fun fromHtml(html: String): Spanned {
    val result: Spanned
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        result = Html.fromHtml(html)
    }
    return result
}

fun getLinkFromTemplateHTML(href: String, text: String, context: Context) = fromHtml(context.getString(R.string.link_template, href, text))

fun getLinkFromTemplate(href: String, text: String, context: Context) = context.getString(R.string.link_template, href, text)
