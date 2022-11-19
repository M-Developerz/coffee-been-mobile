package org.mdeveloperz.mobile.remote.datasource.model

data class UserValidationRemoteResult(
    val isSuccess: Boolean,
    val messages: List<String>
)