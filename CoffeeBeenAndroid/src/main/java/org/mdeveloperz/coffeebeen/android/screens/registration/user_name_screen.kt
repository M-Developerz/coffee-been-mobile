package org.mdeveloperz.coffeebeen.android.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.components.TextInputField
import org.mdeveloperz.coffeebeen.android.components.TextInputFieldValue
import org.mdeveloperz.coffeebeen.android.components.TopToolbar
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.navigation.Screen
import org.mdeveloperz.coffeebeen.android.navigation.makeName
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

@Composable
fun UserNameScreen(
    navController: NavHostController
) {
    var firstName by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "First Name",
                placeHolder = "John"
            )
        )
    }

    var lastName by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "Last Name",
                placeHolder = "Doe"
            )
        )
    }

    fun handleSubmitUserNames() {
        navController.navigate(Screen.CaptureEmailScreen.name)
        val isFirstNameValid = firstName.data.text.isNotEmpty()
        val isLastNameValid = lastName.data.text.isNotEmpty()
        firstName = firstName.copy(
            errorMessage = if (isFirstNameValid) "" else "Required"
        )
        lastName = lastName.copy(
            errorMessage = if (isLastNameValid) "" else "Required"
        )

        if (isLastNameValid && isFirstNameValid) {
            navController.navigate(
                Screen.CaptureEmailScreen.makeName(
                    firstName = firstName.data.text,
                    lastName = lastName.data.text
                )
            )
        }
    }

    Scaffold(
        topBar = { TopToolbar() {} }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            RegistrationHeader(message = "Input Your Name", navController = navController)

            TextInputField(
                value = firstName
            ) {
                firstName = firstName.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            TextInputField(
                value = lastName
            ) {
                lastName = lastName.copy(
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
                Text(text = "Input Account")
            }

            Spacer(modifier = Modifier.weight(weight = 1F, fill = true))
        }
    }
}

@Preview
@Composable
fun UserNameScreenPreview() {
    UserNameScreen(navController = rememberNavController())
}