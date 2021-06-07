package com.zysc.uniartsapp.bean

/**
 *@Date:2021/6/7
 *@Author:Created by peter_ben
 */
data class News(
    val id: Int,
    val type: String,
    val title: String,
    val from: String,
    val label: String,
    val summary: String,
    val content: String,
    val cover: String,
    val link: String,
    val created_at: Long
)
