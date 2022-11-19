package org.mdeveloperz.coffeebeen.android.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mdeveloperz.coffeebeen.android.gray

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TextInputField(
    text: TextFieldValue,
    placeHolder: String,
    label: String,
    onTextValueChanged: (TextFieldValue) -> Unit

) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, color = gray, fontSize = 16.sp)
        Surface(
            modifier = Modifier
                .padding(top = 12.dp)
                .border(
                    width = 1.dp, color = gray, shape = RoundedCornerShape(
                        topStartPercent = 30,
                        bottomStartPercent = 30,
                        topEndPercent = 30,
                        bottomEndPercent = 30

                    )
                )
        ) {
            BasicTextField(
                text,
                onValueChange = onTextValueChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = text.text,
                        innerTextField = innerTextField,
                        placeholder = { Text(text = placeHolder ) },
                        enabled = true,
                        interactionSource = remember { MutableInteractionSource() },
                        singleLine = true,
                        visualTransformation = VisualTransformation.None
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun TextInputFieldPreview() {
//    var text by remember { }
//    TextInputField()
}