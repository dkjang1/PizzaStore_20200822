package com.kakao.pizzastore_20200822.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kakao.pizzastore_20200822.R
import com.kakao.pizzastore_20200822.datas.Store
import de.hdodenhof.circleimageview.CircleImageView

//12:Glide(ManiFest + build.gradle) -> 13:피자가게목록(StoreListFragment.kt)
class StoreListAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Store>
) : ArrayAdapter<Store>(mContext, resId, mList) {

    //12-1:LayoutInflater
    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        var checkRow = convertView
        if (checkRow == null) {
            checkRow = inf.inflate(R.layout.fragment_store_list_item, null)
        }
        val row = checkRow!!

        //12-2:Glide(ManiFest + build.gradle)
        var logoImg = row.findViewById<CircleImageView>(R.id.logoImg)
        var nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        var data = mList[position]
        nameTxt.text = data.name
        Glide.with(mContext).load(data.logoUrl).into(logoImg)

        return row
    }
}