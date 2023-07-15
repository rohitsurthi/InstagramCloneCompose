package com.example.instagramclonecompose.models

data class User(
    val profile: Int,
    val userName: String,
    val storyCount: Int = 0,
    val stories: List<Int> = listOf()
)
