package org.mdeveloperz.mobile.common.domain.repository

import org.mdeveloperz.mobile.common.domain.model.UserModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult

interface UserAuthenticationRepository {
    suspend fun validateUser(user: UserValidationModel): UserValidationResult
    suspend fun createUserAccount(user: UserModel): UserModel
}