package org.mdeveloperz.coffeebeen.android.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mdeveloperz.coffeebeen.android.gray

data class TextInputFieldValue(
    val data: TextFieldValue,
    val errorMessage: String,
    val placeHolder: String,
    val label: String
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TextInputField(
    value: TextInputFieldValue,
    onTextValueChanged: (TextFieldValue) -> Unit

) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = value.label, color = gray, fontSize = 16.sp)
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
                value.data,
                onValueChange = onTextValueChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                decorationBox = @Composable { innerTextField ->
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = value.data.text,
                        innerTextField = innerTextField,
                        placeholder = { Text(text = value.placeHolder) },
                        enabled = true,
                        interactionSource = remember { MutableInteractionSource() },
                        singleLine = true,
                        visualTransformation = VisualTransformation.None
                    )
                }
            )
        }
        Text(
            text = value.errorMessage,
            color = MaterialTheme.colors.error,
            fontSize = 13.sp,
            modifier = Modifier.padding(top = 4.dp)
                .align(Alignment.End)
        )
    }
}

@Preview
@Composable
fun TextInputFieldPreview() {
//    var text by remember { }
//    TextInputField()
}