package com.zysc.uniartsapp.ui

import android.util.Log
import androidx.lifecycle.Observer
import com.zhouwei.mzbanner.holder.MZHolderCreator
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseFragment
import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.databinding.FragmentHomeBinding
import com.zysc.uniartsapp.viewholder.BannerViewHolder
import com.zysc.uniartsapp.viewmodel.HomeFragViewModel
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class HomeFragment : BaseFragment<HomeFragViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId() = R.layout.fragment_home

    override fun initData() {
        mViewModel.apply { getBanner() }
        mViewModel.getBannerLiveData().observe(viewLifecycleOwner, Observer {
            initBanner(it)
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
}