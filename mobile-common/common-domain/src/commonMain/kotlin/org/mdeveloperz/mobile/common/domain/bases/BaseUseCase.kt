package org.mdeveloperz.mobile.common.domain.bases

abstract class BaseUseCase<REQUEST, RESPONSE> {
    abstract suspend fun execute(request: REQUEST): RESPONSE
}