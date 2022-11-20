package org.mdeveloperz.coffeebeen.android.navigation

fun Screen.CaptureEmailScreen.makeName(
    firstName: String,
    lastName: String
) = "capture_email/${firstName}/${lastName}"