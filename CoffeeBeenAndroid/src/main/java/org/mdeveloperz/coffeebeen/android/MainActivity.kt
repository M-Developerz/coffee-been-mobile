package org.mdeveloperz.coffeebeen.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.mdeveloperz.coffeebeen.android.navigation.CoffeeBeenNavHostController
import org.mdeveloperz.coffeebeen.android.screens.MyApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoffeeBeenNavHostController()
                }
            }
        }
    }
}