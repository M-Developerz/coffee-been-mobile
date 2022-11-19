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
import org.mdeveloperz.coffeebeen.android.components.TextInputField
import org.mdeveloperz.coffeebeen.android.components.TextInputFieldValue
import org.mdeveloperz.coffeebeen.android.components.TopToolbar
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

@Composable
fun UserEmailCaptureScreen() {
    var emailAddress by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "Email Address",
                placeHolder = "someone@example.com"
            )
        )
    }

    var username by remember {
        mutableStateOf(
            TextInputFieldValue(
                data = TextFieldValue(""),
                errorMessage = "",
                label = "User Name",
                placeHolder = "someone"
            )
        )
    }

    fun handleSubmitUserNames() {
//        val isFirstNameValid = emailAddress.data.text.isNotEmpty()
//        val isLastNameValid = username.data.text.isNotEmpty()
//        emailAddress = emailAddress.copy(
//            errorMessage = if (isFirstNameValid) "" else "Required"
//        )
//        username = username.copy(
//            errorMessage = if (isLastNameValid) "" else "Required"
//        )
//
//        if (!isLastNameValid && !isFirstNameValid) {
//            println("Submit form")
//        }
    }

    Scaffold(
        topBar = { TopToolbar() {} }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            RegistrationHeader()

            TextInputField(
                value = username
            ) {
                username = username.copy(
                    data = it
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            TextInputField(
                value = emailAddress
            ) {
                emailAddress = emailAddress.copy(
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
                Text(text = "Validate")
            }

            Spacer(modifier = Modifier.weight(weight = 1F, fill = true))
        }
    }
}

@Preview
@Composable
fun UserEmailCaptureScreenPreview() {
    UserEmailCaptureScreen()
}