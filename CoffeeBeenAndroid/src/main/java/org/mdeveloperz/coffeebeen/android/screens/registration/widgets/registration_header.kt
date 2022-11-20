package org.mdeveloperz.coffeebeen.android.screens.registration.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import org.mdeveloperz.coffeebeen.android.gray
import org.mdeveloperz.coffeebeen.android.green

@Composable
fun RegistrationHeader(
    message: String
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
            modifier = Modifier
                .padding(top = 12.dp)
        )
    }
}

@Composable
fun StartHeader() {
    Row(modifier = Modifier
        .padding(vertical = 50.dp)
        .fillMaxWidth()) {
        Spacer(modifier = Modifier.weight(2F))
        Text(
            text = "Coffee", modifier = Modifier,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Been", modifier = Modifier,
            fontSize = 30.sp,
            color = green
        )
        Spacer(modifier = Modifier.weight(2F))
    }
}

@Preview
@Composable
fun StartHeaderPreview() {
    StartHeader()
}