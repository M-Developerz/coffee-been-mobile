package org.mdeveloperz.mobile.common.domain.bases

abstract class BaseUseCase<REQUEST, RESPONSE> {
    @Throws(Exception::class)
    abstract suspend fun execute(request: REQUEST): RESPONSE
}