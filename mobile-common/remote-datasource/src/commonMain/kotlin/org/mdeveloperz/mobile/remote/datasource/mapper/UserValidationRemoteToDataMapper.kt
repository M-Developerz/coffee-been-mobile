package org.mdeveloperz.mobile.remote.datasource.mapper

import org.mdeveloperz.common.datasource.model.UserValidationDataResult
import org.mdeveloperz.mobile.remote.datasource.bases.RemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.model.UserValidationRemoteResult

class UserValidationRemoteToDataMapper :
    RemoteToDataMapper<UserValidationRemoteResult, UserValidationDataResult>() {
    override fun toData(remote: UserValidationRemoteResult) = UserValidationDataResult(
        isSuccess = remote.isSuccess,
        messages = remote.messages
    )
}