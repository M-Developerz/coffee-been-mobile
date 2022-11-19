package org.mdeveloperz.coffeebeen.android.screens.registration.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.mdeveloperz.coffeebeen.android.gray

@Composable
fun RegistrationHeader(
    message: String,
    navController: NavHostController
) {
    Column(modifier = Modifier.padding(bottom = 30.dp)) {
        Text(
            text = "Create New Account", modifier = Modifier,
            fontSize = 26.sp,
        )
        Text(
            text = message,
            fontSize = 16.sp,
            color = gray,
            modifier = Modifier.clickable {
                navController.navigateUp()
            }.padding(top = 12.dp)
        )
    }
}