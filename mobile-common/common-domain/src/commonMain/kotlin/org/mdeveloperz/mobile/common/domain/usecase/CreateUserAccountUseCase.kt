package org.mdeveloperz.mobile.common.domain.usecase

import org.mdeveloperz.mobile.common.domain.bases.BaseUseCase
import org.mdeveloperz.mobile.common.domain.model.UserModel
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

class CreateUserAccountUseCase(
    private val userAuthenticationRepository: UserAuthenticationRepository
): BaseUseCase<UserModel, UserModel>() {
    override suspend fun execute(request: UserModel) = userAuthenticationRepository
        .createUserAccount(request)
}