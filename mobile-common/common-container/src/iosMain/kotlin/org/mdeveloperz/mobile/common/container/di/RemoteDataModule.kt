package org.mdeveloperz.mobile.common.container.di

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.mdeveloperz.common.datasource.datasource.RemoteDataSource
import org.mdeveloperz.mobile.remote.datasource.RemoteDataSourceImpl
import org.mdeveloperz.mobile.remote.datasource.mapper.UserDataToRemoteMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserRemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserValidationDataToDomainMapper
import org.mdeveloperz.mobile.remote.datasource.mapper.UserValidationRemoteToDataMapper
import org.mdeveloperz.mobile.remote.datasource.service.UserAuthenticationService

internal object RemoteDataModule {
    private val client = HttpClient() {
        install(Logging) {
            logger = object: Logger {
                override fun log(message: String) {
                    Napier.v("HTTP Client", null, message)
                }
            }
            level = LogLevel.BODY
            filter { request ->
                request.url.host.contains("ktor.io")
            }
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    private val userDataToRemoteMapper = UserDataToRemoteMapper()
    private val userRemoteToDataMapper = UserRemoteToDataMapper()
    private val userValidationDataToDomainMapper = UserValidationDataToDomainMapper()
    private val userValidationRemoteToDataMapper = UserValidationRemoteToDataMapper()

    private val userAuthenticationService = UserAuthenticationService(client)

    val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl(
        userAuthenticationService = userAuthenticationService,
        userDataToRemoteMapper = userDataToRemoteMapper,
        userRemoteToDataMapper = userRemoteToDataMapper,
        userValidationDataToDomainMapper = userValidationDataToDomainMapper,
        userValidationRemoteToDataMapper = userValidationRemoteToDataMapper
    )
}