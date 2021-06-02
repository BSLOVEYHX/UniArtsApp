package com.zysc.uniartsapp.network.net

import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.network.model.BaseModel
import com.zysc.uniartsapp.network.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@Date:2021/5/31
 *@Author:Created by peter_ben
 */
interface ApiService {

    @GET("/api/v2/banners")
    suspend fun getBanner(@Query("platform") platform: Int): BaseResponse<MutableList<Banners>>
}