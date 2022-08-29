package com.example.submission1aplikasigithubuser.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RepoResponse(

	@field:SerializedName("RepoResponse")
	val repoResponse: List<RepoResponseItem>
) : Parcelable

@Parcelize
data class RepoResponseItem(
	@field:SerializedName("full_name")
	val fullName: String
) : Parcelable

