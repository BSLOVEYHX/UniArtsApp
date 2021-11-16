package com.zysc.uniartsapp.repository

import com.zysc.uniartsapp.ext.netRequest
import com.zysc.uniartsapp.net.WebService

class UserRepository(private val webService: WebService) {

    suspend fun getHomePageBannerList() = netRequest {
        webService.getHomePageBannerList()
    }
}