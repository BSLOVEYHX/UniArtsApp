package com.zysc.uniartsapp.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

/**
 *@Date:2021/5/31
 *@Author:Created by peter_ben
 */
abstract class BaseActivity<T : ViewModel, M : ViewDataBinding> : AppCompatActivity() {

    lateinit var mViewModel: ViewModel

    lateinit var mDataBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initViewModel()
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
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