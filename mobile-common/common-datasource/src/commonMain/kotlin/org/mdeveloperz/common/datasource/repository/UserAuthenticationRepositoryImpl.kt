package org.mdeveloperz.common.datasource.repository

import org.mdeveloperz.common.datasource.datasource.RemoteDataSource
import org.mdeveloperz.common.datasource.mapper.UserDataToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserDomainToDataMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDataResultToDomainMapper
import org.mdeveloperz.common.datasource.mapper.UserValidationDomainToDataMapper
import org.mdeveloperz.mobile.common.domain.model.UserModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationResult
import org.mdeveloperz.mobile.common.domain.repository.UserAuthenticationRepository

class UserAuthenticationRepositoryImpl(
    private val userDataToDomainMapper: UserDataToDomainMapper,
    private val userDomainToDataMapper: UserDomainToDataMapper,
    private val userValidationDataResultToDomainMapper: UserValidationDataResultToDomainMapper,
    private val userValidationDomainToDataMapper: UserValidationDomainToDataMapper,
    private val remoteDataSource: RemoteDataSource
) : UserAuthenticationRepository {
    override suspend fun validateUser(user: UserValidationModel): UserValidationResult {
        val response = remoteDataSource.validateUser(userValidationDomainToDataMapper.toData(user))
        return userValidationDataResultToDomainMapper.toDomain(response)
    }

    override suspend fun createUserAccount(user: UserModel): UserModel {
        val response = remoteDataSource.createUser(userDomainToDataMapper.toData(user))
        return userDataToDomainMapper.toDomain(response)
    }
}