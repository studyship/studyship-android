package com.tsdev.data.source.response

import com.tsdev.data.Response

data class LoginResponse(
    val email: String,
    val password: String
) : Response