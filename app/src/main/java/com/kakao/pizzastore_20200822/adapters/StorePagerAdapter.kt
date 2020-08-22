package com.kakao.pizzastore_20200822.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kakao.pizzastore_20200822.fragments.StoreListFragment
import com.kakao.pizzastore_20200822.fragments.NicknameFragment

//7:TabLayout(build.gradle) -> 8:TabLayout(acitivity_main.xml)
class StorePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    //7-1:TabLayout 선택할경우
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> StoreListFragment()
            else -> NicknameFragment()
        }
    }

    //7-2:TabLayout 탭개수
    override fun getCount(): Int {
        return 2
    }

    //7-3:TabLayout 이름
    override fun getPageTitle(position: Int): CharSequence? {
        //return super.getPageTitle(position)
        return when (position) {
            0 -> "피자주문"
            else -> "내정보설정"
        }
    }
}