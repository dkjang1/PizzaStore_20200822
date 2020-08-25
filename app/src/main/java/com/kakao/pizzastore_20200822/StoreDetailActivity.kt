package com.kakao.pizzastore_20200822

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.kakao.pizzastore_20200822.datas.Store
import kotlinx.android.synthetic.main.activity_store_detail.*

//15:피자가게상세페이지(Intent) -> 16:피자가게전화걸기(activity_store_detail.xml)
class StoreDetailActivity : BaseActivity() {

    //15-1:Store
    lateinit var mStore: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        setupEvents()
        setValues()
    }

    override fun setValues() {

        //15-2:Intent(activity_store_detail1)
        mStore = intent.getSerializableExtra("storeInfo") as Store //StoreListFragment:IntentName
        nameTxt.text = mStore.name
        phoneNumTxt.text = mStore.phoneNum
        Glide.with(mContext).load(mStore.logoUrl).into(logoImg)
    }

    override fun setupEvents() {

        //17:피자가게전화걸기(Manifest + Tedpermission) -> 18:닉네임변경-New-EmptyActivity(activity_nickname.xml)
        callBtn.setOnClickListener {
            val permissionListener = object : PermissionListener {
                //승인되었을경우
                override fun onPermissionGranted() {
                    val telUri = Uri.parse("tel:${mStore.phoneNum}")
                    val telIntent = Intent(Intent.ACTION_CALL, telUri)
                    startActivity((telIntent))
                }

                //거부되었을경우
                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화연결권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정}에서 권한을 확인해야 전화연결이 가능합니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

    }

}