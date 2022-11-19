package org.mdeveloperz.mobile.common.container.di

import org.mdeveloperz.common.datasource.datasource.RemoteDataSource
import org.mdeveloperz.common.datasource.mapper.UserDataToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserDomainToDataMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDataResultToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDomainToDataMapper
import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataResult
import org.mdeveloperz.common.datasource.repository.UserAuthenticationRepositoryImpl
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

internal object CommonDataModule {
    private val userDataToDomainMapper = UserDataToDomainMapper()
    private val userDomainToDataMapper = UserDomainToDataMapper()
    private val userValidationDataResultToDomainMapper = UserValidationDataResultToDomainMapper()
    private val userValidationDomainToDataMapper = UserValidationDomainToDataMapper()
    private val remoteDataSource = object : RemoteDataSource {
        override suspend fun validateUser(user: UserValidationDataModel) = UserValidationDataResult(
            isSuccess = true,
            messages = listOf("username valid", "email valid")
        )

        override suspend fun createUser(user: UserDataModel) = UserDataModel(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            id = 2,
            username = user.username
        )

    }
    val userAuthenticationRepository: UserAuthenticationRepository =
        UserAuthenticationRepositoryImpl(
            userDataToDomainMapper,
            userDomainToDataMapper,
            userValidationDataResultToDomainMapper,
            userValidationDomainToDataMapper,
            remoteDataSource
        )
}