package org.mdeveloperz.common.datasource.datasource

import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataResult

interface RemoteDataSource {
    suspend fun validateUser(user: UserValidationDataModel): UserValidationDataResult
    suspend fun createUser(user: UserDataModel): UserDataModel
}