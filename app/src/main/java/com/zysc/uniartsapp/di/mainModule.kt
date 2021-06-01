package com.zysc.uniartsapp.di

import com.zysc.uniartsapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Date:2021/6/1
 *@Author:Created by peter_ben
 */

val treeViewModelModule = module {
    viewModel { MainViewModel() }
}