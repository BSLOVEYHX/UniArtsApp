package com.zysc.uniartsapp.ext

import com.zysc.uniartsapp.constant.REQUEST_TIMEOUT
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

suspend fun <T> netRequest(block: suspend CoroutineScope.() -> T): T {
    return withContext(Dispatchers.IO) {
        withTimeout(REQUEST_TIMEOUT) {
            block.invoke(this)
        }
    }
}