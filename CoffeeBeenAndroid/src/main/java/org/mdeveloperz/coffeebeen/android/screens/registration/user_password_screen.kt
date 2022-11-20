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
import org.mdeveloperz.coffeebeen.android.components.*
import org.mdeveloperz.coffeebeen.android.green
import org.mdeveloperz.coffeebeen.android.presentation.createaccount.CreateUserAccountViewModel
import org.mdeveloperz.coffeebeen.android.presentation.createaccount.CreateUserAccountViewState
import org.mdeveloperz.coffeebeen.android.presentation.createaccount.EMPTY_STATE
import org.mdeveloperz.coffeebeen.android.presentation.createaccount.isLoading
import org.mdeveloperz.coffeebeen.android.presentation.model.UserPresentationModel
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
    argument: UserPasswordScreenArgument = EMPTY_ARGUMENT,
    viewModel: CreateUserAccountViewModel = hiltViewModel()
) {
    val viewState: State<CreateUserAccountViewState> = viewModel.viewState.collectAsState(EMPTY_STATE)
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
        val isFirstNameValid = password.data.text.isNotEmpty()
        val isLastNameValid = confirmPassword.data.text.isNotEmpty()
        password = password.copy(
            errorMessage = if (isFirstNameValid) "" else "Required"
        )
        confirmPassword = confirmPassword.copy(
            errorMessage = if (isLastNameValid) "" else "Required"
        )

        if (isLastNameValid && isFirstNameValid) {
            viewModel.onCreateUserAction(
                UserPresentationModel(
                    firstName = argument.firstName,
                    lastName = argument.lastName,
                    username = argument.username,
                    email = argument.email,
                    password = password.data.text
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

            if (viewState.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Button(
                onClick = ::handleSubmitUserNames,
                modifier = Modifier
                    .padding(top = 50.dp)
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