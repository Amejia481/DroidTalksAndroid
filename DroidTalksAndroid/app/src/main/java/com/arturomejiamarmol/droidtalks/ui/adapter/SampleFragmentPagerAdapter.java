package com.arturomejiamarmol.droidtalks.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arturomejiamarmol.droidtalks.R;
import com.arturomejiamarmol.droidtalks.ui.fragment.PageFragment;

/**
 * Created by Arturo Mejia on 5/9/2017.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter{
    
    private String tabTitles[];
    private Context mContext;
    
    public SampleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.mContext = context;
        tabTitles =  mContext.getResources()
                .getStringArray(R.array.main_activity_titles);
    }
    
    
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
    
    @Override
    public Fragment getItem(int position) {
        
        return PageFragment.newInstance(position);
    }
    
    @Override
    public int getCount() {
        return tabTitles.length;
    }
}
