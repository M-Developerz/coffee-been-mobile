package org.mdeveloperz.common.datasource.model

data class UserDataModel(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val id: Int? = null,
    val password: String? = null
)