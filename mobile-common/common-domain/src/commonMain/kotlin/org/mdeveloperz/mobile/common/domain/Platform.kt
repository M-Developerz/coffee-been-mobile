package org.mdeveloperz.mobile.common.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform