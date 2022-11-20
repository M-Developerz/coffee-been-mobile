package org.mdeveloperz.coffeebeen.android.presentation.mapper

import org.mdeveloperz.coffeebeen.android.presentation.bases.PresentationToDomainMapper
import org.mdeveloperz.coffeebeen.android.presentation.model.UserPresentationModel
import org.mdeveloperz.mobile.common.domain.model.UserModel

class UserPresentationToDomainMapper: PresentationToDomainMapper<UserPresentationModel, UserModel>() {
    override fun toDomain(presentation: UserPresentationModel) = UserModel(
        firstName = presentation.firstName,
        lastName = presentation.lastName,
        username = presentation.username,
        email = presentation.email,
        id = presentation.id,
        password = presentation.password
    )
}