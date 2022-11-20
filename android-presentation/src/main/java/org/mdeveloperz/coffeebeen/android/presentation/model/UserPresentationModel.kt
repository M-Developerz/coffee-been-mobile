package org.mdeveloperz.coffeebeen.android.presentation.model

data class UserPresentationModel(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val id: Int? = null,
    val password: String? = null
)