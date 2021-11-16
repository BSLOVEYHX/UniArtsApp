package com.zysc.uniartsapp.net

import com.zysc.uniartsapp.constant.NET_RESPONSE_CODE_FAILED
import kotlinx.serialization.Serializable

@Serializable
data class NetResult<T>(
    val errorCode: Int = NET_RESPONSE_CODE_FAILED,
    val errorMsg: String? = "",
    val data: T? = null
)

