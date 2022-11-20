package org.mdeveloperz.coffeebeen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mdeveloperz.common.datasource.datasource.RemoteDataSource
import org.mdeveloperz.common.datasource.mapper.UserDataToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserDomainToDataMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDataResultToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDomainToDataMapper
import org.mdeveloperz.common.datasource.repository.UserAuthenticationRepositoryImpl
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun providesUserDataToDomainMapper() = UserDataToDomainMapper()

    @Provides
    fun providesUserDomainToDataMapper() = UserDomainToDataMapper()

    @Provides
    fun providesUserValidationDataResultToDomainMapper() = UserValidationDataResultToDomainMapper()

    @Provides
    fun providesUserValidationDomainToDataMapper() = UserValidationDomainToDataMapper()

    @Provides
    fun providesUserAuthenticationRepository(
        userDataToDomainMapper: UserDataToDomainMapper,
        userDomainToDataMapper: UserDomainToDataMapper,
        userValidationDataResultToDomainMapper: UserValidationDataResultToDomainMapper,
        userValidationDomainToDataMapper: UserValidationDomainToDataMapper,
        remoteDataSource: RemoteDataSource
    ): UserAuthenticationRepository = UserAuthenticationRepositoryImpl(
        userDataToDomainMapper = userDataToDomainMapper,
        userDomainToDataMapper = userDomainToDataMapper,
        userValidationDataResultToDomainMapper = userValidationDataResultToDomainMapper,
        userValidationDomainToDataMapper = userValidationDomainToDataMapper,
        remoteDataSource = remoteDataSource
    )
}