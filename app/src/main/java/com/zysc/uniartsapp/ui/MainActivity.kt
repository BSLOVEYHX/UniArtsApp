package com.zysc.uniartsapp.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.get
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zysc.uniartsapp.R
import com.zysc.uniartsapp.base.BaseActivity
import com.zysc.uniartsapp.base.FixFragmentNavigator
import com.zysc.uniartsapp.databinding.ActivityMainBinding
import com.zysc.uniartsapp.viewmodel.MainViewModel

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private lateinit var navController: NavController
    private lateinit var bottomNavView: BottomNavigationView

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun initView() {
        bottomNavView = mViewBinding.bottomNavigation
        bottomNavView.itemIconTintList = null
        //添加自定义的FixFragmentNavigator
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val fragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val fragmentNavigator =
            FixFragmentNavigator(this, supportFragmentManager, fragment!!.id)
        navController.navigatorProvider.addNavigator(fragmentNavigator)
        navController.setGraph(R.navigation.mobile_navigation)
        bottomNavView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
//        如果调用 super.onBackPressed()，navigation会操作回退栈,切换到之前显示的页面，导致 页面叠加错乱
//        super.onBackPressed()
        val id = navController.currentDestination?.id!!
        val homeNavi = navController.graph[R.id.navigation_home].id
        if (id != homeNavi) {
            bottomNavView.selectedItemId = R.id.navigation_home
        } else {
            finish()
        }
    }
}