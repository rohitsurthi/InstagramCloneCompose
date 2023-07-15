package com.example.instagramclonecompose.models

data class Post(
    val profile: Int,
    val userName: String,
    val postPhotoList: List<Int>,
    val description: String,
    val postLikedBy: List<User>
)

