package org.mdeveloperz.mobile.common.container

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform