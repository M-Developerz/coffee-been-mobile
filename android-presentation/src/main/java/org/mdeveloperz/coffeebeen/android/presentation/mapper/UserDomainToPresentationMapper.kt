package org.mdeveloperz.coffeebeen.android.presentation.mapper

import org.mdeveloperz.coffeebeen.android.presentation.bases.DomainToPresentation
import org.mdeveloperz.coffeebeen.android.presentation.model.UserPresentationModel
import org.mdeveloperz.mobile.common.domain.model.UserModel

class UserDomainToPresentationMapper: DomainToPresentation<UserModel, UserPresentationModel>() {
    override fun toPresentation(domain: UserModel) = UserPresentationModel(
        firstName = domain.firstName,
        lastName = domain.lastName,
        username = domain.username,
        email = domain.email,
        id = domain.id,
        password = domain.password
    )
}