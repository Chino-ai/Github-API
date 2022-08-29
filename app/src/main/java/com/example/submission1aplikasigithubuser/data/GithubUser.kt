package com.example.submission1aplikasigithubuser.data


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var username: String,
    var name: String,
    var avatar: Int,
    var follower: String,
    var Following: String,
    var company: String,
    var location: String,
    var repository: String
) : Parcelable
