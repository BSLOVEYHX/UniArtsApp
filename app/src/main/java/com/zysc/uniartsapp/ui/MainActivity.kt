package com.zysc.uniartsapp.ui

import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseActivity
import com.zysc.uniartsapp.databinding.ActivityMainBinding
import com.zysc.uniartsapp.viewmodel.MainViewModel

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        mViewBinding.bottomNavigation.itemIconTintList = null
    }
}