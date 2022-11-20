package org.mdeveloperz.coffeebeen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {
    @Provides
    fun providesUserDataToRemoteMapper() = UserDataToRemoteMapper()

    @Provides
    fun providesUserRemoteToDataMapper() = UserRemoteToDataMapper()

    @Provides
    fun providesUserValidationDataToDomainMapper() = UserValidationDataToDomainMapper()

    @Provides
    fun providesUserValidationRemoteToDataMapper() = UserValidationRemoteToDataMapper()

    @Provides
    fun providesUserAuthenticationService(client: HttpClient) = UserAuthenticationService(client)

    @Provides
    fun providesHttpClient() = HttpClient() {
        install(Logging) {
            logger = object : Logger {
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

    @Provides
    fun providesRemoteDataSource(
        userAuthenticationService: UserAuthenticationService,
        userDataToRemoteMapper: UserDataToRemoteMapper,
        userRemoteToDataMapper: UserRemoteToDataMapper,
        userValidationDataToDomainMapper: UserValidationDataToDomainMapper,
        userValidationRemoteToDataMapper: UserValidationRemoteToDataMapper
    ): RemoteDataSource = RemoteDataSourceImpl(
        userAuthenticationService = userAuthenticationService,
        userDataToRemoteMapper = userDataToRemoteMapper,
        userRemoteToDataMapper = userRemoteToDataMapper,
        userValidationDataToDomainMapper = userValidationDataToDomainMapper,
        userValidationRemoteToDataMapper = userValidationRemoteToDataMapper
    )
}