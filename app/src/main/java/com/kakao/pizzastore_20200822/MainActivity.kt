package com.kakao.pizzastore_20200822

import android.os.Bundle
import com.kakao.pizzastore_20200822.adapters.StorePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

/*
//1:Baseactivity(BaseActivity.kt) -> 2:ViewPager만들기(activity_main.xml)
<!--2:피자가게목록(ViewPager) -> 3:피자가게목록(fragment_store_list.xml) -->
<!--3:피자가게목록 -> 4:피자가게목록(StoreListFragment.kt)-->
//4:피자가게목록 -> 5:내정보변경(fragment_nickname.xml)-->
<!--5:내정보변경 -> 6:내정보변경(NicknameFragment.kt)-->
//6:내정보변경 -> 7:TabLayout(StorePagerAdapter.kt)
//7:TabLayout -> 8:TabLayout(acitivity_main.xml)
<!--8:TabLayout -> 9:TabLayout(MainActivity.kt)-->
//9:TabLayout -> 10:피자가게목록(data:Store.kt)
//10:피자가게목록(Serializable) -> 11:피자가게목록(fragment_store_list_item.xml)
<!--11:피자가게목록(CircleImageView) -> 12:피자가게목록(StoreListAdapter.kt)-->
//12:피자가게목록 -> 13:피자가게목록(StoreListFragment.kt)
//13:피자가게목록(ArrayList) -> 14:피자가게상세페이지(activity_store_detail.xml)
<!--14:피자가게상세페이지 -> 15:피자가게상세페이지(StoreDetailActivity)-->
//15:피자가게상세페이지(Intent) -> 16:피자가게전화걸기
*/

//1:Baseactivity(BaseActivity.kt) -> 2:ViewPager만들기(activity_main.xml)
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    //9:TabLayout -> 10:피자가게목록(data:Store.kt)
    lateinit var mpa: StorePagerAdapter

    override fun setValues() {

        //9-1:MainPagerAdapter(supportFragmentManager)
        mpa = StorePagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mpa
        //9-2:build.gradle+activity_main.xml
        mainTabLayout.setupWithViewPager(mainViewPager)

    }

}