package com.kakao.pizzastore_20200822.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakao.pizzastore_20200822.NicknameActivity
import com.kakao.pizzastore_20200822.R
import kotlinx.android.synthetic.main.fragment_nickname.*

//6:내정보변경 -> 7:TabLayout(StorePagerAdapter.kt)
class NicknameFragment : Fragment() {

    //6-1:onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_nickname, container, false)
    }

    //20:닉네임변겅
    val REQ_FOR_NICKNAME = 1000

    //6-2:onActivityCreated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //20-1:닉네임변겅
        changeNicknameBtn.setOnClickListener {
            val nickIntent = Intent(context!!, NicknameActivity::class.java)
            startActivityForResult(nickIntent, REQ_FOR_NICKNAME)
        }
    }

    //20-2:닉네임변겅(완료)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_FOR_NICKNAME) {
            if(resultCode == Activity.RESULT_OK){
                nowNicknameTxt.text = data?.getStringExtra("nickname")
            }
        }
    }
}