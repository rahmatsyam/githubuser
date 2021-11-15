package com.github.githubuserdicoding.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class UserResponse(

	@Json(name="users")
	val users: List<UsersItem>
)

@Parcelize
data class UsersItem(

	@Json(name="follower")
	val follower: Int,

	@Json(name="following")
	val following: Int,

	@Json(name="name")
	val name: String,

	@Json(name="company")
	val company: String,

	@Json(name="location")
	val location: String,

	@Json(name="avatar")
	val avatar: String,

	@Json(name="repository")
	val repository: Int,

	@Json(name="username")
	val username: String
) : Parcelable
