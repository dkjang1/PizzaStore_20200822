package com.kakao.pizzastore_20200822.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kakao.pizzastore_20200822.R
import com.kakao.pizzastore_20200822.StoreDetailActivity
import com.kakao.pizzastore_20200822.adapters.StoreListAdapter
import com.kakao.pizzastore_20200822.datas.Store
import kotlinx.android.synthetic.main.fragment_store_list.*

//4:피자가게목록 -> 5:내정보변경(fragment_nickname.xml)-->
class StoreListFragment : Fragment() {

    //13:피자가게목록(ArrayList) -> 14:피자가게상세페이지(activity_store_detail.xml)
    val mPizzaStoreList = ArrayList<Store>()
    lateinit var mStoreListAdapter: StoreListAdapter

    //4-1:onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        //fragment_store_list 레이아웃
        return inflater.inflate(R.layout.fragment_store_list, container, false)
    }

    //4-2:onActivityCreated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //13-1:피자가게목록(ArrayList.add)
        mPizzaStoreList.add(
            Store(
                "피자헛",
                "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg",
                "1588-5588"
            )
        )
        mPizzaStoreList.add(
            Store(
                "파파존스",
                "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800",
                "1577-8080"
            )
        )
        mPizzaStoreList.add(
            Store(
                "미스터피자",
                "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200",
                "1577-0077"
            )
        )
        mPizzaStoreList.add(
            Store(
                "도미노피자",
                "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png",
                "1577-3082"
            )
        )
        //13-2:피자가게목록(ArrayList)
        mStoreListAdapter = StoreListAdapter(context!!, R.layout.fragment_store_list_item, mPizzaStoreList)
        pizzaStoreListView.adapter = mStoreListAdapter


        //13-3:피자가게상세페이지(StoreListFragment)
        pizzaStoreListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedStore = mPizzaStoreList[position]
            val storeIntent = Intent(context, StoreDetailActivity::class.java)
            storeIntent.putExtra("storeInfo", clickedStore) //StoreDetailActivity:IntentName
            startActivity(storeIntent)

        }

    }


}