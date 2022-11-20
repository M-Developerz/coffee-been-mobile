package org.mdeveloperz.coffeebeen.android.screens.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.mdeveloperz.coffeebeen.android.components.TopToolbar
import org.mdeveloperz.coffeebeen.android.screens.registration.widgets.RegistrationHeader

@Composable
fun VerificationCodeScreen(
    navigationController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopToolbar() {} }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            RegistrationHeader(message = "Input OTP Verification")
        }
    }
}

@Preview
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen()
}