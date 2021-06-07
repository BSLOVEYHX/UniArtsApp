package com.zysc.uniartsapp.network.net

import com.zysc.uniartsapp.bean.Banners
import com.zysc.uniartsapp.bean.News
import com.zysc.uniartsapp.network.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *@Date:2021/5/31
 *@Author:Created by peter_ben
 */
interface ApiService {

    //首页Banner
    @GET("/api/v2/banners")
    suspend fun getBanner(
        @Query("platform") platform: Int
    ): BaseResponse<MutableList<Banners>>

    // 新闻列表
    @GET("/api/v2/news")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("type") type: String
    ): BaseResponse<MutableList<News>>
}