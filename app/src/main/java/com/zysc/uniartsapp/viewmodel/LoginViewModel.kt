package com.zysc.uniartsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.wj.common.ext.orEmpty
import com.orhanobut.logger.Logger
import com.zysc.uniartsapp.Entity.BannerEntity
import com.zysc.uniartsapp.base.BaseViewModel
import com.zysc.uniartsapp.ext.judge
import com.zysc.uniartsapp.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : BaseViewModel() {

   private val _bannerData: MutableLiveData<ArrayList<BannerEntity>> = MutableLiveData()

    val bannerData: LiveData<ArrayList<BannerEntity>> = _bannerData

    /**获取首页Banner列表*/
    fun getHomePageBannerList() {
        viewModelScope.launch {
            try {
                repository.getHomePageBannerList().judge(
                    onSuccess = {
                        _bannerData.value = data.orEmpty()
                    }, onFailed = { Logger.t("LoginViewModel").e("onFailed") })
            } catch (throwable: Throwable) {
                Logger.t("NET").e(throwable, "NET_ERROR")
            }
        }
    }
}