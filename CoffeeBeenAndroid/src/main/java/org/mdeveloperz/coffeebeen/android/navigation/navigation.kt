package org.mdeveloperz.coffeebeen.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import org.mdeveloperz.coffeebeen.android.screens.registration.UserNameScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.screens.registration.UserEmailCaptureScreen
import org.mdeveloperz.coffeebeen.android.screens.registration.UserPasswordScreen
import org.mdeveloperz.coffeebeen.android.screens.registration.VerificationCodeScreen


sealed class Screen(val name: String) {
    object CaptureNameScreen : Screen(name = "capture_name")
    object CaptureEmailScreen : Screen(name = "capture_email")
    object CapturePasswordScreen : Screen(name = "capture_password")
    object OTPVerificationScreen : Screen(name = "otp_verification")
}

@Composable
fun CoffeeBeenNavHostController(
    navigationController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navigationController,
        startDestination = Screen.CaptureNameScreen.name
    ) {
        composable(Screen.CaptureNameScreen.name) {
            UserNameScreen(navController = navigationController)
        }

        composable(Screen.CaptureEmailScreen.name) {
            UserEmailCaptureScreen(navigationController = navigationController)
        }

        composable(Screen.CapturePasswordScreen.name) {
            UserPasswordScreen(navigationController = navigationController)
        }

        composable(Screen.OTPVerificationScreen.name) {
            VerificationCodeScreen(navigationController = navigationController)
        }
    }
}