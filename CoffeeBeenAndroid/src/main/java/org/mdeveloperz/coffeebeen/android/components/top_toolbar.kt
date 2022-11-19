package org.mdeveloperz.coffeebeen.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopToolbar(onBackAction: () -> Unit) {
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
    ) {
        Icon(
            Icons.Rounded.ArrowBack,
            contentDescription = "Back Arrow",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterVertically)
                .clickable { onBackAction() },
        )
    }
}

@Preview
@Composable
fun TopToolbarPreview() {
    TopToolbar() {

    }
}