package org.mdeveloperz.common.datasource.mapper

import org.mdeveloperz.common.datasource.bases.DataToDomainMapper
import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.mobile.common.domain.model.UserModel

class UserDataToDomainMapper: DataToDomainMapper<UserDataModel, UserModel>() {
    override fun toDomain(data: UserDataModel) = UserModel(
        firstName = data.firstName,
        lastName = data.lastName,
        email = data.email,
        password = data.password,
        id = data.id,
        username = data.username
    )
}