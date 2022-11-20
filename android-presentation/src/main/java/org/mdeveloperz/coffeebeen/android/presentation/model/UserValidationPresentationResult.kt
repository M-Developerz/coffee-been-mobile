package org.mdeveloperz.coffeebeen.android.presentation.model


sealed class UserValidationPresentationResult {
    object Empty : UserValidationPresentationResult()
    data class Data(
        val isSuccess: Boolean,
        val messages: List<String>
    ) : UserValidationPresentationResult()
}