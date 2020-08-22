package com.kakao.pizzastore_20200822

import android.os.Bundle
import com.kakao.pizzastore_20200822.adapters.StorePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

//1:Baseactivity 상속 -> 2:ViewPager만들기(activity_main)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    //6:TabLayout(PagerAdapter)
    lateinit var mpa: StorePagerAdapter

    override fun setValues() {

        //6-1:MainPagerAdapter(supportFragmentManager)
        mpa = StorePagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mpa
        //6-2:build.gradle+activity_main.xml
        mainTabLayout.setupWithViewPager(mainViewPager)

    }

}