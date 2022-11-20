package org.mdeveloperz.coffeebeen.android.navigation

fun makeUserEmailCaptureScreenArgument(
    firstName: String,
    lastName: String
) = "capture_email/${firstName}/${lastName}"