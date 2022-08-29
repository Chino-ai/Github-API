package com.example.submission1aplikasigithubuser.API


import com.example.submission1aplikasigithubuser.data.source.remote.response.DetailResponse
import com.example.submission1aplikasigithubuser.data.source.remote.response.RepoResponse

import com.example.submission1aplikasigithubuser.data.source.remote.response.UserResponse


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun getUser(
        @Query("q") id: String
    ): Call<UserResponse>


    @GET("users/{login}")
    fun getUserDetail(
        @Path("login") id: String
    ): Call<DetailResponse>

    @GET("users/{login}/repos")
    fun getRepo(
        @Path("login") id: String
    ): Call<RepoResponse>


}