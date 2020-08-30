package com.tsdev.remote.network

import com.tsdev.data.Api
import com.tsdev.remote.data.CheckUserRequest
import com.tsdev.remote.data.CheckUserResponse
import com.tsdev.remote.data.login.LoginRequest
import com.tsdev.remote.data.signin.SignInResponse
import com.tsdev.remote.data.signin.SignInUserInfoRequest
import com.tsdev.remote.data.user.DetailUserResponse
import retrofit2.http.*

interface StudyShipUserAPI : Api {
    @POST("/users")
    fun signInStudyShipUser(
        @Body signInUserInfo: SignInUserInfoRequest
    ): SignInResponse

    @POST("/users/email")
    fun checkedIsAlreadyUser(
        @Body userNameResponse: CheckUserRequest
    ): CheckUserResponse

    @POST("/users/login")
    fun signInUser(
        @Body loginRequest: LoginRequest
    ): SignInResponse

    @GET("/users/{id}")
    fun getDetailUserInfo(
        @Path("id") userID: Int
    ): DetailUserResponse

    @PUT("/users/{id}")
    fun patchUserInfo(
        @Path("id") userID: Int
    ): DetailUserResponse
}