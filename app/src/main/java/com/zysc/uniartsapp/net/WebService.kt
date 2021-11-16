package com.zysc.uniartsapp.net

import com.zysc.uniartsapp.Entity.BannerEntity
import retrofit2.http.GET

interface WebService {
    @GET(UrlDefinition.GET_HOMEPAGE_BANNER_LIST)
    suspend fun getHomePageBannerList(): NetResult<ArrayList<BannerEntity>>
}