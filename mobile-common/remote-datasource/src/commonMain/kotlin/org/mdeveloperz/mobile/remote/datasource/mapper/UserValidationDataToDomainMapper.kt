package org.mdeveloperz.mobile.remote.datasource.mapper

import org.mdeveloperz.common.datasource.model.UserValidationDataModel
import org.mdeveloperz.mobile.remote.datasource.bases.DataToRemoteMapper
import org.mdeveloperz.mobile.remote.datasource.model.UserValidationRemoteModel

class UserValidationDataToDomainMapper :
    DataToRemoteMapper<UserValidationDataModel, UserValidationRemoteModel>() {
    override fun toRemote(data: UserValidationDataModel) = UserValidationRemoteModel(
        email = data.email,
        username = data.username
    )
}