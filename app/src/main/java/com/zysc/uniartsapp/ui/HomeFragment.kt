package com.zysc.uniartsapp.ui

import android.util.Log
import androidx.lifecycle.Observer
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseFragment
import com.zysc.uniartsapp.databinding.FragmentHomeBinding
import com.zysc.uniartsapp.viewmodel.HomeFragViewModel

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class HomeFragment : BaseFragment<HomeFragViewModel, FragmentHomeBinding>() {

    override fun getLayoutResId() = R.layout.fragment_home

    override fun initData() {
        mViewModel.apply { getBanner() }
        mViewModel.getBannerLiveData().observe(viewLifecycleOwner, Observer {
        })
    }

    override fun initView() {
    }
}