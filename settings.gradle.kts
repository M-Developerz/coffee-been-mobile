pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoffeeBeen"
include(":CoffeeBeenAndroid")
include(":shared")
include(":android-presentation")
include(":mobile-common:common-domain")
include(":mobile-common:common-container")
include(":mobile-common:common-datasource")
include(":mobile-common:remote-datasource")
