package com.zysc.uniartsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseFragment
import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.bean.News
import com.zysc.uniartsapp.databinding.FragmentHomeBinding
import com.zysc.uniartsapp.viewholder.BannerViewHolder
import com.zysc.uniartsapp.viewmodel.HomeFragViewModel

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class HomeFragment : BaseFragment<HomeFragViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId() = R.layout.fragment_home

    override fun initData() {
        mViewModel.apply { getBanner() }
        mViewModel.getBannerLiveData().observe(viewLifecycleOwner, {
            initBanner(it)
        })

        mViewModel.apply { getNews(1, "New::Announcement") }
        mViewModel.getNewsLiveData().observe(viewLifecycleOwner, {
            initNews(it)
        })
    }

    override fun initView() {
    }

    private fun initBanner(banners: List<Banners>) {
        val bannerList = ArrayList<Banners>()
        bannerList.addAll(banners)
        mDataBinding.banner.setPages(bannerList) { BannerViewHolder() }
        mDataBinding.banner.start()
    }

    private fun initNews(news: List<News>) {
        if (news.isNotEmpty()) {
            for (i in news.indices step 2) {
                val new: News = news[i]
                var new2: News? = null
                if(i + 1 < news.size){
                    new2 = news[i + 1]
                }
                val view =LayoutInflater.from(requireContext()).inflate(R.layout.item_flipper,null)
                val newItem1 = view.findViewById<TextView>(R.id.tv_notice)
                val newItem2 = view.findViewById<TextView>(R.id.tv_notice2)
                newItem1.text = new.title
                if(new2 != null){
                    newItem2.text = new2.title
                }else{
                    newItem2.visibility = View.GONE
                }
                mDataBinding.noticeFlipper.addView(view)
//                val index = i
            }
            mDataBinding.noticeFlipper.startFlipping()
        }
    }
}