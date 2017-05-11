package com.arturomejiamarmol.droidtalks.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arturomejiamarmol.droidtalks.R;
import com.arturomejiamarmol.droidtalks.ui.adapter.SampleFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),this));
        tabLayout.setupWithViewPager(viewPager);
        
    }
}
