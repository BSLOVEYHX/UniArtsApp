package com.zysc.uniartsapp.network.net

import com.zysc.uniartsapp.network.exception.DealException
import com.zysc.uniartsapp.network.exception.ResultException
import com.zysc.uniartsapp.network.model.BaseModel
import com.zysc.uniartsapp.network.model.BaseResponse
import com.zysc.uniartsapp.network.model.NetResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope


open class BaseRepository {

    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }

    suspend fun <T : Any> handleResponse(
        response: BaseResponse<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.head.code == -1) {
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(
                        response.head.code.toString(),
                        response.head.msg
                    )
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.body)
            }
        }
    }
}