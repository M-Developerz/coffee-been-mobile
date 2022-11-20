package org.mdeveloperz.coffeebeen.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.screens.StartScreen
import org.mdeveloperz.coffeebeen.android.screens.registration.*


sealed class Screen(val name: String) {
    object AppStartScreen : Screen("start")
    object CaptureNameScreen : Screen(name = "capture_name")
    object CaptureEmailScreen : Screen(name = "capture_email/{firstName}/{lastName}")
    object CapturePasswordScreen :
        Screen(name = "capture_password/{firstName}/{lastName}/{username}/{email}")

    object OTPVerificationScreen : Screen(name = "otp_verification")
}

@Composable
fun CoffeeBeenNavHostController(
    navigationController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navigationController,
        startDestination = Screen.AppStartScreen.name
    ) {
        composable(Screen.CaptureNameScreen.name) {
            UserNameScreen(navController = navigationController)
        }

        composable(Screen.CaptureEmailScreen.name) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""

            UserEmailCaptureScreen(
                navigationController = navigationController,
                arguments = UserEmailCaptureScreenArguments(
                    firstName = firstName,
                    lastName = lastName
                )
            )
        }

        composable(Screen.CapturePasswordScreen.name) { backStackEntry ->
            val firstName = backStackEntry.arguments?.getString("firstName") ?: ""
            val lastName = backStackEntry.arguments?.getString("lastName") ?: ""
            val username = backStackEntry.arguments?.getString("username") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""

            UserPasswordScreen(
                navigationController = navigationController, argument = UserPasswordScreenArgument(
                    firstName = firstName,
                    lastName = lastName,
                    username = username,
                    email = email
                )
            )
        }

        composable(Screen.OTPVerificationScreen.name) {
            VerificationCodeScreen(navigationController = navigationController)
        }

        composable(Screen.AppStartScreen.name) {
            StartScreen(navigationController = navigationController)
        }
    }
}