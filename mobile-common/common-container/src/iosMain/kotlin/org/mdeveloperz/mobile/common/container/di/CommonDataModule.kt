package org.mdeveloperz.mobile.common.container.di

import org.mdeveloperz.common.datasource.mapper.UserDataToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserDomainToDataMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDataResultToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDomainToDataMapper
import org.mdeveloperz.common.datasource.repository.UserAuthenticationRepositoryImpl
import org.mdeveloperz.mobile.common.container.di.RemoteDataModule.remoteDataSource
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

internal object CommonDataModule {
    private val userDataToDomainMapper = UserDataToDomainMapper()
    private val userDomainToDataMapper = UserDomainToDataMapper()
    private val userValidationDataResultToDomainMapper = UserValidationDataResultToDomainMapper()
    private val userValidationDomainToDataMapper = UserValidationDomainToDataMapper()
    val userAuthenticationRepository: UserAuthenticationRepository =
        UserAuthenticationRepositoryImpl(
            userDataToDomainMapper,
            userDomainToDataMapper,
            userValidationDataResultToDomainMapper,
            userValidationDomainToDataMapper,
            remoteDataSource
        )
}