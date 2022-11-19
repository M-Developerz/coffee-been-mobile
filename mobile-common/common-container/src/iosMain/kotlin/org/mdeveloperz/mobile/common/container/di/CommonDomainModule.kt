package org.mdeveloperz.mobile.common.container.di

import org.mdeveloperz.mobile.common.domain.model.UserModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository
import org.mdeveloperz.mobile.common.domain.usecase.CreateUserAccountUseCase
import org.mdeveloperz.mobile.common.domain.usecase.ValidateUserUseCase

object CommonDomainModule {
    private val userAuthenticationRepository: UserAuthenticationRepository =
        object : UserAuthenticationRepository {
            override suspend fun validateUser(user: UserValidationModel) = UserValidationResult(
                isSuccess = true,
                messages = listOf("username valid", "email valid")
            )

            override suspend fun createUserAccount(user: UserModel) = UserModel(
                firstName = user.firstName,
                lastName = user.lastName,
                email = user.email,
                id = 2,
                username = user.username
            )

        }

    val createUserAccountUseCase = CreateUserAccountUseCase(
        userAuthenticationRepository
    )

    val validateUserUseCase = ValidateUserUseCase(userAuthenticationRepository)
}