package org.mdeveloperz.mobile.remote.datasource.mapper

import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.mobile.remote.datasource.bases.RemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.model.UserRemoteModel

class UserRemoteToDataMapper : RemoteToDataMapper<UserRemoteModel, UserDataModel>() {
    override fun toData(remote: UserRemoteModel) = UserDataModel(
        firstName = remote.first_name,
        lastName = remote.last_name,
        username = remote.username,
        password = remote.password,
        id = remote.id,
        email = remote.email
    )
}