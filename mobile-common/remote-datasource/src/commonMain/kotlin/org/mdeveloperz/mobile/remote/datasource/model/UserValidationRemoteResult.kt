package org.mdeveloperz.mobile.remote.datasource.model

import kotlinx.serialization.Serializable

@Serializable
data class UserValidationRemoteResult(
    val isSuccess: Boolean,
    val messages: List<String>
)