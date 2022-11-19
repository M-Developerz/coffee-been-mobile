package org.mdeveloperz.mobile.common.domain.model

sealed class UserValidationResult {
    object Success : UserValidationResult()
    data class Failure(val message: String) : UserValidationResult()
}