package com.kakao.pizzastore_20200822.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakao.pizzastore_20200822.R

//6:내정보변경 -> 7:TabLayout(StorePagerAdapter.kt)
class NicknameFragment: Fragment() {

    //6-1:onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_nickname, container, false)
    }

    //6-2:onActivityCreated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}