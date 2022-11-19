package org.mdeveloperz.mobile.common.domain.model

data class UserModel(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val id: Int? = null,
    val password: String? = null
)