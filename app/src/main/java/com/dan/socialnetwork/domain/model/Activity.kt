package com.dan.socialnetwork.domain.model

data class Activity(
    val username: String,
    val action: Action,
    val timestamp: Long = System.currentTimeMillis()
) {
    sealed class Action {

        object LikedPost : Action()
        object CommentedOnPost: Action()
        object LikedComment : Action()
    }
}