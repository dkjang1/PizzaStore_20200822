package com.kakao.pizzastore_20200822

import androidx.appcompat.app.AppCompatActivity

//STEP1:BaseActivity만들기
abstract class BaseActivity : AppCompatActivity() {
    val mContext = this
    abstract fun setupEvents()
    abstract fun setValues()
}