package org.mdeveloperz.mobile.remote.datasource

import org.mdeveloperz.common.datasource.datasource.RemoteDataSource
import org.mdeveloperz.common.datasource.model.UserDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataModel
import org.mdeveloperz.common.datasource.model.UserValidationDataResult
import org.mdeveloperz.mobile.remote.datasource.mapper.UserDataToRemoteMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserRemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserValidationDataToDomainMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserValidationRemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.service.UserAuthenticationService

class RemoteDataSourceImpl(
    private val userAuthenticationService: UserAuthenticationService,
    private val userDataToRemoteMapper: UserDataToRemoteMapper,
    private val userRemoteToDataMapper: UserRemoteToDataMapper,
    private val userValidationDataToDomainMapper: UserValidationDataToDomainMapper,
    private val userValidationRemoteToDataMapper: UserValidationRemoteToDataMapper
) : RemoteDataSource {
    override suspend fun validateUser(user: UserValidationDataModel): UserValidationDataResult {
        val response =
            userAuthenticationService.validateUser(userValidationDataToDomainMapper.toRemote(user))
        return userValidationRemoteToDataMapper.toData(response)
    }

    override suspend fun createUser(user: UserDataModel): UserDataModel {
        val response =
            userAuthenticationService.createUserAccount(userDataToRemoteMapper.toRemote(user))
        return userRemoteToDataMapper.toData(response)
    }
}