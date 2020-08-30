package com.tsdev.remote.data.study.detail

data class StudyCommentsRequest(
    val body: String,
    val parent_id: Int = 0
)