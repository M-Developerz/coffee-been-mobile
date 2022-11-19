package org.mdeveloperz.mobile.remote.datasource.mapper

import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.mobile.remote.datasource.bases.DataToRemoteMapper
import org.mdeveloperz.mobile.remote.datasource.model.UserRemoteModel

class UserDataToRemoteMapper : DataToRemoteMapper<UserDataModel, UserRemoteModel>() {
    override fun toRemote(data: UserDataModel) = UserRemoteModel(
        firstName = data.firstName,
        lastName = data.lastName,
        username = data.username,
        email = data.email,
        id = data.id,
        password = data.password
    )
}