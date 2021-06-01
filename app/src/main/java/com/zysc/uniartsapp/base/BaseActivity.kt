package com.zysc.uniartsapp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.zysc.utils.StatusBarKt
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

/**
 *@Date:2021/5/31
 *@Author:Created by peter_ben
 */
abstract class BaseActivity<T : ViewModel, M : ViewDataBinding> : AppCompatActivity() {

    lateinit var mViewModel: T

    lateinit var mViewBinding: M

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarKt.fitSystemBar(this)
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutResId())

        initViewModel()
        initData()
        initView()
    }

    abstract fun getLayoutResId(): Int

    abstract fun initData()

    abstract fun initView()

    private fun initViewModel() {
        val clazz =
            this.javaClass.kotlin.supertypes[0].arguments[0].type!!.classifier!! as KClass<T>
        mViewModel = getViewModel<T>(clazz) //koin 注入
    }
}