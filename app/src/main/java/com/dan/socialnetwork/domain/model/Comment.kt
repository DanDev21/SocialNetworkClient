package com.dan.socialnetwork.domain.model

data class Comment(
    val id: Int = -1,
    val username: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val text: String = "",
    val likes: Int = 0,
)
