package com.dan.socialnetwork.core.domain.model

data class Comment(
    val id: String = "",
    val username: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val text: String = "",
    val likes: Int = 0,
)
