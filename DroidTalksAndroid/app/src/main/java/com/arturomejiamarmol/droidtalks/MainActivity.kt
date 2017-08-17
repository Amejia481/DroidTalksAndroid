package com.arturomejiamarmol.droidtalks

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        viewPager.adapter = MainActivityTabPagerAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPager)

    }


}
