package com.zysc.uniartsapp.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.network.model.NetResult
import com.zysc.uniartsapp.repository.HomeRepository
import com.zysc.utils.BaseContext
import kotlinx.coroutines.launch

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class HomeFragViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val bannerLiveData = MutableLiveData<List<Banners>>()

    fun getBannerLiveData() = bannerLiveData

    fun getBanner() {
        viewModelScope.launch {
            val banner = homeRepository.getHomeBanner()
            if (banner is NetResult.Success) {
                bannerLiveData.postValue(banner.data)
            } else if (banner is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    banner.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}