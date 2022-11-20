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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.components.TextInputField
import org.mdeveloperz.coffeebeen.android.components.TextInputFieldValue
import org.mdeveloperz.coffeebeen.android.components.TopToolbar
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationModel
import org.mdeveloperz.coffeebeen.android.presentation.viewmodel.EMPTY_STATE
import org.mdeveloperz.coffeebeen.android.presentation.viewmodel.UserValidationViewModel
import org.mdeveloperz.coffeebeen.android.presentation.viewmodel.UserValidationViewState
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

@Composable
fun UserEmailCaptureScreen(
    navigationController: NavHostController = rememberNavController(),
    viewModel: UserValidationViewModel = hiltViewModel()
) {
    val viewState: State<UserValidationViewState> = viewModel.viewState.collectAsState(EMPTY_STATE)

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
        val isFirstNameValid = emailAddress.data.text.isNotEmpty()
        val isLastNameValid = username.data.text.isNotEmpty()
        emailAddress = emailAddress.copy(
            errorMessage = if (isFirstNameValid) "" else "Required"
        )
        username = username.copy(
            errorMessage = if (isLastNameValid) "" else "Required"
        )

        if (isLastNameValid && isFirstNameValid) {
            viewModel.onValidUserAction(
                UserValidationPresentationModel(
                    username = username.data.text,
                    email = emailAddress.data.text
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
            RegistrationHeader(message = "Input Your Email", navController = navigationController)

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

            Text(text = "${viewState.value.loadingState}")
            Text(text = "${viewState.value.data}")

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