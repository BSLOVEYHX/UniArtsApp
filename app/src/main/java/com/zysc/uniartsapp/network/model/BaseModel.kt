package com.zysc.uniartsapp.network.model

data class BaseModel<out T>(val errorCode: Int, val errorMsg: String, val data: T)