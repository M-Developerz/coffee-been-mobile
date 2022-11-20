package org.mdeveloperz.coffeebeen.android.navigation


fun makeCapturePasswordScreenArgument(
    firstName: String,
    lastName: String,
    username: String,
    email: String
) = "capture_password/${firstName}/${lastName}/${username}/${email}"