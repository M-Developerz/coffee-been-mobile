package org.mdeveloperz.coffeebeen.android.presentation.mapper

import org.mdeveloperz.coffeebeen.android.presentation.bases.DomainToPresentation
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationResult
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult

class UserValidationDomainToPresentationMapper: DomainToPresentation<UserValidationResult, UserValidationPresentationResult.Data>() {
    override fun toPresentation(domain: UserValidationResult) = UserValidationPresentationResult.Data(
        isSuccess = domain.isSuccess,
        messages = domain.messages
    )
}