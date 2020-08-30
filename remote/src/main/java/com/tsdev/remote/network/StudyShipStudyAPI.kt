package com.tsdev.remote.network

import com.tsdev.data.Api
import com.tsdev.remote.data.study.CreateStudyRequest
import com.tsdev.remote.data.study.CreateStudyResponse
import com.tsdev.remote.data.study.StudyResponse
import com.tsdev.remote.data.study.detail.DetailStudyResponse
import com.tsdev.remote.data.study.detail.StudyCommentsRequest
import com.tsdev.remote.data.study.detail.StudyCommentsResponse
import retrofit2.http.*

interface StudyShipStudyAPI : Api {
    @GET("/studies")
    fun loadAllStudies(): List<StudyResponse>

    @FormUrlEncoded
    @POST("/studies")
    fun createStudy(
        @Body
        studyInfo: CreateStudyRequest
    ): CreateStudyResponse

    @GET("/studies/{id}")
    fun getDetailStudy(
        @Path("id") studyId: Int
    ): DetailStudyResponse

    @GET("/studies/{id}/comments")
    fun getDetailStudyComments(
        @Path("id") studyId: Int
    ): StudyCommentsResponse

    @POST("studies/{id}/comments")
    fun postUserComments(
        @Body commentsRequest: StudyCommentsRequest
    )
}