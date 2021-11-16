package com.zysc.uniartsapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.orhanobut.logger.Logger
import com.wj.android.okhttp.BuildConfig
import com.wj.android.okhttp.InterceptorLogger
import com.wj.android.okhttp.LoggerInterceptor
import com.zysc.uniartsapp.net.UrlDefinition
import com.zysc.uniartsapp.net.WebService
import com.zysc.uniartsapp.repository.UserRepository
import com.zysc.uniartsapp.tools.jsonDefault
import com.zysc.uniartsapp.viewmodel.LoginViewModel
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

/**网络请求 Module*/
val netModule: Module = module {

    val logger = object : InterceptorLogger {
        override fun invoke(msg: String) {
            Logger.t("NET").i(msg)
        }
    }
    //单例模式
    single {
        OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
//            .cookieJar(object : CookieJar {
//                override fun loadForRequest(url: HttpUrl): List<Cookie> {
//                    TODO("Not yet implemented")
//                }
//
//                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
//                    TODO("Not yet implemented")
//                }
//
//            })
            .addNetworkInterceptor(
                LoggerInterceptor(
                    logger,
                    if (BuildConfig.DEBUG) LoggerInterceptor.LEVEL_BODY else LoggerInterceptor.LEVEL_NONE
                )
            )
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(UrlDefinition.BASE_URL)
            .addConverterFactory(jsonDefault.asConverterFactory("application/json;charset=UTF-8".toMediaType()))
            .client(get())
            .build()
    }

    single<WebService> {
        get<Retrofit>().create(WebService::class.java)
    }
}

/** 数据仓库 Module */
val repositoryModule: Module = module {
    factory { UserRepository(get()) }
}

/**ViewModel Module*/
val viewModelModule: Module = module {
    viewModel { LoginViewModel(get()) }
}