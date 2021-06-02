package com.zysc.uniartsapp.di

import com.google.gson.GsonBuilder
import com.zysc.uniartsapp.network.net.RetrofitClient
import org.koin.dsl.module

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */

val otherModule = module {

    single {
        RetrofitClient.instance
    }

    single {
        GsonBuilder().disableHtmlEscaping().create()
    }
}


val allModule = listOf(
    otherModule, treeViewModelModule, treeRepoModule
)