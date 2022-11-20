package org.mdeveloperz.coffeebeen.android.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import org.mdeveloperz.coffeebeen.android.navigation.Screen
import org.mdeveloperz.coffeebeen.android.navigation.makeCapturePasswordScreenArgument
import org.mdeveloperz.coffeebeen.android.navigation.makeUserEmailCaptureScreenArgument
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationModel
import org.mdeveloperz.coffeebeen.android.presentation.validateuser.EMPTY_STATE
import org.mdeveloperz.coffeebeen.android.presentation.validateuser.UserValidationViewModel
import org.mdeveloperz.coffeebeen.android.presentation.validateuser.UserValidationViewState
import org.mdeveloperz.coffeebeen.android.presentation.validateuser.isLoading
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

data class UserEmailCaptureScreenArguments(
    val firstName: String,
    val lastName: String
)

private val EMPTY_ARGUMENT = UserEmailCaptureScreenArguments("", "")

@Composable
fun UserEmailCaptureScreen(
    navigationController: NavHostController = rememberNavController(),
    viewModel: UserValidationViewModel = hiltViewModel(),
    arguments: UserEmailCaptureScreenArguments = EMPTY_ARGUMENT
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

    fun handleSubmitUsernameAndEmail() {
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

            navigationController.navigate(
                makeCapturePasswordScreenArgument(
                    firstName = arguments.firstName,
                    lastName = arguments.lastName,
                    email = emailAddress.data.text,
                    username = username.data.text
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
            RegistrationHeader(message = "Input Your Email")

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

            if (viewState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Button(
                onClick = ::handleSubmitUsernameAndEmail,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = green,
                    contentColor = Color.White
                ),
                enabled = !viewState.value.isLoading
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