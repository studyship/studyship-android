package com.tsdev.remote.data.signin

data class SignInResponse(
    val bio: String,
    val created_at: String,
    val email: String,
    val email_verified: Boolean,
    val token: String,
    val updated_at: String,
    val username: String
)