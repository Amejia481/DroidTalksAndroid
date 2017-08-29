package com.arturomejiamarmol.droidtalks

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.arturomejiamarmol.droidtalks.creators.CreatorsFragment
import com.arturomejiamarmol.droidtalks.events.EventsFragment
import com.arturomejiamarmol.droidtalks.topics.TopicsTalksFragment

/**
 * Created by Arturo Mejia on 5/9/2017.
 */

class MainActivityTabPagerAdapter(fm: FragmentManager, private val mContext: Context) : FragmentPagerAdapter(fm) {

    private val tabTitles = mContext.resources
            .getStringArray(R.array.main_activity_titles)


    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TopicsTalksFragment.newInstance()
            1 -> EventsFragment.newInstance()
            2 -> CreatorsFragment.newInstance()
            else -> TopicsTalksFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return tabTitles.size
    }
}
