package com.zysc.uniartsapp.di

import com.zysc.uniartsapp.repository.HomeRepository
import com.zysc.uniartsapp.viewmodel.HomeFragViewModel
import com.zysc.uniartsapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */

val treeRepoModule = module {
    single { HomeRepository(get()) }
}

val treeViewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { HomeFragViewModel(get()) }
}