package org.mdeveloperz.coffeebeen.android.presentation.mapper

import org.mdeveloperz.coffeebeen.android.presentation.bases.PresentationToDomainMapper
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel

class UserValidationPresentationToDomainMapper: PresentationToDomainMapper<UserValidationPresentationModel, UserValidationModel>() {
    override fun toDomain(presentation: UserValidationPresentationModel) = UserValidationModel(
        username = presentation.username,
        email = presentation.email
    )
}