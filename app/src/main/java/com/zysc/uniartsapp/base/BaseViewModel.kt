package com.zysc.uniartsapp.base

import androidx.lifecycle.MutableLiveData
import com.wj.android.ui.viewmodel.BaseLibViewModel

abstract class BaseViewModel : BaseLibViewModel() {

    /** 控制 UI 组件关闭 */
//    val uiCloseData = MutableLiveData<UiCloseModel>()

    /** 界面跳转控制 */
    val uiNavigationData = MutableLiveData<String>()
}