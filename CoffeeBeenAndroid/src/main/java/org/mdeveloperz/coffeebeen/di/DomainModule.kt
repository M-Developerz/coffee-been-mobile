package org.mdeveloperz.coffeebeen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository
import org.mdeveloperz.mobile.common.domain.usecase.CreateUserAccountUseCase
import org.mdeveloperz.mobile.common.domain.usecase.ValidateUserUseCase

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providesCreateUserAccountUseCase(
        userAuthenticationRepository: UserAuthenticationRepository
    ) = CreateUserAccountUseCase(userAuthenticationRepository)

    @Provides
    fun providesValidateUserUseCase(
        userAuthenticationRepository: UserAuthenticationRepository
    ) = ValidateUserUseCase(userAuthenticationRepository)
}