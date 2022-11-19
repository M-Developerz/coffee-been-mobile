package org.mdeveloperz.common.datasource.mapper

import org.mdeveloperz.common.datasource.bases.DomainToDataMapper
import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.mobile.common.domain.model.UserModel

class UserDomainToDataMapper : DomainToDataMapper<UserModel, UserDataModel>() {
    override fun toData(domain: UserModel) = UserDataModel(
        firstName = domain.firstName,
        lastName = domain.lastName,
        username = domain.username,
        email = domain.email,
        password = domain.password,
        id = domain.id,
    )
}