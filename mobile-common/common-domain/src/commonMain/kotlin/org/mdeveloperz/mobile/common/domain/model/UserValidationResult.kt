package org.mdeveloperz.mobile.common.domain.model

data class UserValidationResult(
    val isSuccess: Boolean,
    val messages: List<String>
)