package com.dan.socialnetwork.core.domain.model

data class Post(
    val username: String,
    val imageUrl: String,
    val profilePictureUrl: String,
    val description: String,
    val likes: Int,
    val comments: Int
)
