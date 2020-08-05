package com.tsdev.data.source.response

import com.tsdev.data.Response
import com.tsdev.data.source.Category

data class JoinStudyResponse(
    val studyTitle: String,
    val studyLocation: String,
    val studyDate: String,
    val studyMakeTime: String,
    val adminName: String,
    val members: String,
    val comments: List<Comments>,
    val category: List<Category>
) : Response {
    data class Comments(val userName: String, val contents: String)
}