package org.mdeveloperz.mobile.remote.datasource.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRemoteModel(
    val first_name: String,
    val last_name: String,
    val username: String,
    val email: String,
    val id: Int? = null,
    val password: String? = null
)