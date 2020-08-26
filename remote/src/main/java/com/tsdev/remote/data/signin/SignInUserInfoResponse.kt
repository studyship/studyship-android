package com.tsdev.remote.data.signin

data class SignInUserInfoRequest(
    val bio: String,
    val email: String,
    val interests: List<Int>,
    val password: String,
    val username: String
)