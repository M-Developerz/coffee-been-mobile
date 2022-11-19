package org.mdeveloperz.coffeebeen.android.screens.registration

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mdeveloperz.coffeebeen.android.components.TextInputField
import org.mdeveloperz.coffeebeen.android.components.TopToolbar
import org.mdeveloperz.coffeebeen.android.gray
import org.mdeveloperz.coffeebeen.android.green

@Composable
fun UserNameScreen() {
    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = { TopToolbar() {} }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(top = 20.dp, start = 12.dp, end = 12.dp)
        ) {
            Column(modifier = Modifier.padding(bottom = 30.dp)) {
                Text(
                    text = "Create New Account", modifier = Modifier,
                    fontSize = 26.sp,
                )
                Text(
                    text = "Input Your Name",
                    fontSize = 16.sp,
                    color = gray,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            TextInputField(
                text = firstName,
                placeHolder = "John",
                label = "First Name"
            ) {
                firstName = it
            }

            Spacer(modifier = Modifier.height(15.dp))

            TextInputField(
                text = lastName,
                placeHolder = "Doe",
                label = "Last Name"
            ) {
                lastName = it
            }

            Spacer(modifier = Modifier.weight(weight = 5F, fill = true))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
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
    UserNameScreen()
}