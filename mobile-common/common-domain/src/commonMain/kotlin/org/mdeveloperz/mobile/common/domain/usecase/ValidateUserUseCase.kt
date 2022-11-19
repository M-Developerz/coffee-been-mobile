package org.mdeveloperz.mobile.common.domain.usecase

import org.mdeveloperz.mobile.common.domain.bases.BaseUseCase
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

class ValidateUserUseCase(
    private val userAuthenticationRepository: UserAuthenticationRepository
) : BaseUseCase<UserValidationModel, UserValidationResult>() {

    override suspend fun execute(request: UserValidationModel) = userAuthenticationRepository
        .validateUser(request)
}