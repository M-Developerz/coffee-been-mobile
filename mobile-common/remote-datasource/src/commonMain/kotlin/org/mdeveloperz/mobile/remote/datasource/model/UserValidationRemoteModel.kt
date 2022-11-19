package org.mdeveloperz.mobile.remote.datasource.model

import kotlinx.serialization.Serializable

@Serializable
data class UserValidationRemoteModel(
    val username: String,
    val email: String
)