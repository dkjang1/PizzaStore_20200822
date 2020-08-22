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

//9:피자가게목록(StoreListAdapter) -> 10:피자가게목록(StoreListFragment)
class StoreListAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Store>
) : ArrayAdapter<Store>(mContext, resId, mList) {

    //9-1:getView()
    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        var checkRow = convertView
        if (checkRow == null) {
            checkRow = inf.inflate(R.layout.fragment_store_list_item, null)
        }
        val row = checkRow!!

        //9-2:data
        var logoImg = row.findViewById<CircleImageView>(R.id.logoImg)
        var nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        var data = mList[position]
        nameTxt.text = data.name
        Glide.with(mContext).load(data.logoUrl).into(logoImg)

        return row
    }
}