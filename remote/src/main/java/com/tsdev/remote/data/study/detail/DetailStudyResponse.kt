package com.tsdev.remote.data.study.detail

data class DetailStudyResponse(
    val categories: List<Category>,
    val cpatain: Cpatain,
    val created_at: String,
    val current_recruitment: Int,
    val days: List<Int>,
    val goal: String,
    val id: Int,
    val level: Int,
    val number_of_comments: Int,
    val place: String,
    val recruitment: Int,
    val thumbnail: String,
    val time: Int,
    val title: String,
    val updated_at: String
) {
    data class Category(
        val child: List<Any?>,
        val id: Int,
        val name: String
    )

    data class Cpatain(
        val id: Int,
        val profile_image: String,
        val username: String
    )
}



