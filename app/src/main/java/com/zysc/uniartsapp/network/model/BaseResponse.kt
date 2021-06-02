package com.zysc.uniartsapp.network.model

import java.io.Serializable

/**
 *@Date:2021/6/2
 *@Author:Created by peter_ben
 */
data class BaseResponse<out T>(val head: HeadBean, val body: T) : Serializable