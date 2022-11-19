package org.mdeveloperz.mobile.remote.datasource.service

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.mdeveloperz.mobile.remote.datasource.BASE_URL
import org.mdeveloperz.mobile.remote.datasource.model.UserRemoteModel
import org.mdeveloperz.mobile.remote.datasource.model.UserValidationRemoteModel
import org.mdeveloperz.mobile.remote.datasource.model.UserValidationRemoteResult

class UserAuthenticationService(
    private val client: HttpClient
) {
    suspend fun validateUser(user: UserValidationRemoteModel): UserValidationRemoteResult {
        val response = client.post("${BASE_URL}/check-email-and-password/") {
            contentType(ContentType.Application.Json)
            setBody(user)
        }
        return response.body()
    }

    suspend fun createUserAccount(user: UserRemoteModel): UserRemoteModel {
        val response = client.post("${BASE_URL}/users/") {
            contentType(ContentType.Application.Json)
            setBody(user)
        }
        return response.body()
    }
}