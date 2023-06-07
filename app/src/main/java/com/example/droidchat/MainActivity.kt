package com.example.droidchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import com.example.droidchat.theme.DroidChatTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    DroidChatTheme {
                        Surface(
                            color = MaterialTheme.colorScheme.background,
                            modifier = Modifier.nestedScroll(rememberNestedScrollInteropConnection())
                        ) {
                            ChatScreen()
                        }
                    }
                }
            }
        )
    }
}
