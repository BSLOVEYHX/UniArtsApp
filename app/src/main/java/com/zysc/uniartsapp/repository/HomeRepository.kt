package com.zysc.uniartsapp.repository

import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.network.model.NetResult
import com.zysc.uniartsapp.network.net.ApiService
import com.zysc.uniartsapp.network.net.BaseRepository
import com.zysc.uniartsapp.network.net.RetrofitClient

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */
class HomeRepository(private val retrofitClient: RetrofitClient) : BaseRepository() {

    suspend fun getHomeBanner(): NetResult<List<Banners>> {
        return callRequest(call = { requestBanner() })
    }

    private suspend fun requestBanner() =
        handleResponse(retrofitClient.create(ApiService::class.java).getBanner(1))

}