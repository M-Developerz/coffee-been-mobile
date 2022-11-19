package org.mdeveloperz.common.datasource.mapper

import org.mdeveloperz.common.datasource.bases.DataToDomainMapper
import org.mdeveloperz.common.datasource.model.UserValidationDataResult
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult

class UserValidationDataResultToDomainMapper :
    DataToDomainMapper<UserValidationDataResult, UserValidationResult>() {
    override fun toDomain(data: UserValidationDataResult) = UserValidationResult(
        messages = data.messages,
        isSuccess = data.isSuccess
    )
}