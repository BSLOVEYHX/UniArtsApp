package com.zysc.uniartsapp.network.model

import com.zysc.uniartsapp.network.exception.ResultException


sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : NetResult<T>()

    data class Error(val exception: ResultException) : NetResult<Nothing>()


}