package org.mdeveloperz.mobile.common.container.di

import org.mdeveloperz.mobile.common.container.di.CommonDataModule.userAuthenticationRepository
import org.mdeveloperz.mobile.common.domain.usecase.CreateUserAccountUseCase
import org.mdeveloperz.mobile.common.domain.usecase.ValidateUserUseCase

object DomainModule {
    val createUserAccountUseCase = CreateUserAccountUseCase(userAuthenticationRepository)
    val validateUserUseCase = ValidateUserUseCase(userAuthenticationRepository)
}