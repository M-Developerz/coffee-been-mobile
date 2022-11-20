package org.mdeveloperz.coffeebeen.android.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.components.*
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

data class UserPasswordScreenArgument(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String
)

private val EMPTY_ARGUMENT = UserPasswordScreenArgument("", "", "", "")

@Composable
fun UserPasswordScreen(
    navigationController: NavHostController = rememberNavController(),
    argument: UserPasswordScreenArgument = EMPTY_ARGUMENT
) {
    var password by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "Password",
                placeHolder = "*****"
            )
        )
    }

    var confirmPassword by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "Confirm Password",
                placeHolder = "*****"
            )
        )
    }

    fun handleSubmitUserNames() {
    }

    Scaffold(
        topBar = { TopToolbar() {} }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            RegistrationHeader(message = "Input Your Password", navController = navigationController)

            PasswordInputField(
                value = password
            ) {
                password = password.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            PasswordInputField(
                value = confirmPassword
            ) {
                confirmPassword = confirmPassword.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.weight(weight = 5F, fill = true))

            Button(
                onClick = ::handleSubmitUserNames,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = green,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Create Account")
            }

            Spacer(modifier = Modifier.weight(weight = 1F, fill = true))
        }
    }
}

@Preview
@Composable
fun UserPasswordScreenPreview() {
    UserPasswordScreen()
}