package com.tsdev.remote.data.study.detail

data class StudyCommentsResponse(
    val comments: List<Comment>
) {
    data class Comment(
        val body: String,
        val created_at: String,
        val id: Int,
        val recomments: List<Recomment>,
        val updated_at: String,
        val writer: WriterX
    ) {
        data class Recomment(
            val body: String,
            val createdAt: String,
            val id: Int,
            val updatedAt: String,
            val writer: Writer
        ) {
            data class Writer(
                val id: Int,
                val profile_image: String,
                val username: String
            )
        }

        data class WriterX(
            val id: Int,
            val profile_image: String,
            val username: String
        )
    }
}






