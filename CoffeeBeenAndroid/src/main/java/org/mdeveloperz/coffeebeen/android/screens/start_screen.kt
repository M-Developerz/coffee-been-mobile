package org.mdeveloperz.coffeebeen.android.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.components.PasswordInputField
import org.mdeveloperz.coffeebeen.android.components.TextInputField
import org.mdeveloperz.coffeebeen.android.components.TextInputFieldValue
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.navigation.Screen
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.StartHeader

@Composable
fun StartScreen(
    navigationController: NavHostController = rememberNavController()
) {
    var username by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "Username",
                placeHolder = "someone"
            )
        )
    }

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

    fun handleLogin() {
    }

    fun handleCreateUserAccount() {
        navigationController.navigate(Screen.CaptureNameScreen.name)
    }

    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            StartHeader()

            TextInputField(
                value = username
            ) {
                username = username.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            PasswordInputField(
                value = password
            ) {
                password = password.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.weight(weight = 5F, fill = true))

            Button(
                onClick = ::handleCreateUserAccount,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = green,
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = green,
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Create Account")
            }

            Button(
                onClick = ::handleLogin,
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = green,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.weight(weight = 1F, fill = true))
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen()
}