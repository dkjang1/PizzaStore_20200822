package com.kakao.pizzastore_20200822

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kakao.pizzastore_20200822.datas.Store
import kotlinx.android.synthetic.main.activity_store_detail.*

//12:피자가게상세페이지(Intent) -> 13:피자가게전화걸기
class StoreDetailActivity : BaseActivity() {

    //12-1:Store
    lateinit var mStore: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        //12-2:Intent(activity_store_detail1)
        mStore = intent.getSerializableExtra("storeInfo") as Store //StoreListFragment:IntentName
        nameTxt.text = mStore.name
        phoneNumTxt.text = mStore.phoneNum
        Glide.with(mContext).load(mStore.logoUrl).into(logoImg)
    }


}