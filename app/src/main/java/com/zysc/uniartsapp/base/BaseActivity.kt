package com.zysc.uniartsapp.base

//import com.alibaba.android.arouter.launcher.ARouter
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.wj.android.ui.activity.BaseBindingLibActivity
import com.zysc.uniartsapp.R

/**
 *@Date:2021/5/31
 *@Author:Created by peter_ben
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> :
    BaseBindingLibActivity<VM, DB>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initImmersionbar()

        observeData()
    }


    /** 初始化状态栏相关配置 */
    protected open fun initImmersionbar(immersionBar: ImmersionBar) {}

    /** 初始化状态栏相关配置 */
    private fun initImmersionbar() {
        immersionBar {
            statusBarColor(R.color.app_colorPrimary)
            statusBarDarkFont(false)
            fitsSystemWindows(true)
            initImmersionbar(this)
            addTag(javaClass.simpleName)
        }
    }


    /** 添加观察者 */
    private fun observeData() {
        // 界面跳转
        viewModel.uiNavigationData.observe(this, { path ->
//            ARouter.getInstance().build(path).navigation(mContext)
        })
    }
}

