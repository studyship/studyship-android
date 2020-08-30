package com.tsdev.remote.data.user

data class DetailUserResponse(
    val bio: String,
    val created_at: String,
    val email: String,
    val interests: List<Interest>,
    val profile_image: String,
    val updated_at: String,
    val username: String
) {
    data class Interest(
        val id: Int,
        val name: String
    )
}

