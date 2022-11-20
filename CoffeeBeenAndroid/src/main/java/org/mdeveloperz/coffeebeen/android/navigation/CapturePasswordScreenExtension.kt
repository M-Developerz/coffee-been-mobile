package org.mdeveloperz.coffeebeen.android.navigation


fun Screen.CapturePasswordScreen.makeName(
    firstName: String,
    lastName: String,
    username: String,
    email: String
) = "capture_password/${firstName}/${lastName}/${username}/${email}"