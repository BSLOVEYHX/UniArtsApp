package com.zysc.uniartsapp.network.interceptor

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.lang.reflect.Type

/**
 *@Date:2021/6/2
 *@Author:Created by peter_ben
 */
class LoggingInterceptor : Interceptor {

    private var mGson: Gson = GsonBuilder()
        .registerTypeAdapter(object : TypeToken<HashMap<String, Any>>() {}.type,
            object : JsonDeserializer<HashMap<String, Any>> {
                override fun deserialize(
                    json: JsonElement?,
                    typeOfT: Type?,
                    context: JsonDeserializationContext?
                ): HashMap<String, Any> {
                    val hashMap = java.util.HashMap<String, Any>()
                    val jsonObject = json!!.asJsonObject
                    val entrySet = jsonObject.entrySet()
                    for ((key, value) in entrySet) {
                        hashMap[key] = value
                    }
                    return hashMap
                }
            }).create()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = addHeaders(request.newBuilder())
        return chain.proceed(builder)
    }

    private fun addHeaders(builder: Request.Builder): Request {
        return builder.addHeader("Content_Type", "application/json")
            .addHeader("charset", "UTF-8")
            .addHeader("Accept-Language", "zh-CN").build()
    }
}