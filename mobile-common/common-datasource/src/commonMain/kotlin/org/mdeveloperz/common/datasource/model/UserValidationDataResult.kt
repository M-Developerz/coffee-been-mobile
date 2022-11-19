package org.mdeveloperz.common.datasource.model

data class UserValidationDataResult(
    val isSuccess: Boolean,
    val messages: List<String>
)