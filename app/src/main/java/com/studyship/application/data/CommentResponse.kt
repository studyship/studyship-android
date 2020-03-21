package com.studyship.application.data

data class CommentResponse(val reCommentList: List<ReCommentResponse>)


data class ReCommentResponse(
    val content: String,
    val writer_id: String,
    val create_datetime: String,
    val update_datetime: String
)