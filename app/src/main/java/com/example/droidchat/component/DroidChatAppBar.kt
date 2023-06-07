package com.example.droidchat.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.droidchat.theme.DroidChatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DroidChatAppBar(
    title: @Composable () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account Settings"
                )
            }
        }
    )
}

@Preview
@Composable
fun DroidChatAppBarPreview() {
    DroidChatTheme {
        DroidChatAppBar(title = { Text("Preview!") })
    }
}

@Preview
@Composable
fun DroidChatAppBarPreviewDarkTheme() {
    DroidChatTheme(isDarkTheme = true) {
        DroidChatAppBar(title = { Text("Preview!") })
    }
}
