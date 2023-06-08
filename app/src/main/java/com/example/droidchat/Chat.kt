package com.example.droidchat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidchat.component.DroidChatAppBar
import com.example.droidchat.theme.DroidChatTheme

@Composable
fun ChatScreen() {
    var text by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Message>() }
    val listState = rememberLazyListState()

    Scaffold(
        topBar = { DroidChatAppBar(title = { Text("Droid Chat") }) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                state = listState
            ) {
                items(messages) { message ->
                    MessageView(message)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.weight(1f),
                    label = { Text("Type a message") }
                )
                Button(
                    onClick = {
                        messages.add(Message(text, true))
                        text = ""
                        // TODO: Send text to GPT-3 and get response
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text("Send")
                }
            }
        }
    }
}

@Composable
fun MessageView(message: Message) {
    val textStyle = LocalTextStyle.current
    CompositionLocalProvider(LocalTextStyle provides textStyle) {
        Card(
            modifier = Modifier
                .padding(48.dp, 8.dp, 12.dp, 8.dp)
                .fillMaxWidth()
                .wrapContentWidth(if (message.isUser) Alignment.End else Alignment.Start),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = message.content,
                modifier = Modifier.padding(16.dp, 12.dp),
            )
        }
    }
}

@Preview
@Composable
fun MessagePreview() {
    DroidChatTheme {
        MessageView(
            message = Message(
                content = "得益于苹果的广泛关注度，原本定位于开发者技术会议的 WWDC，其关注面越发延伸到一般技术爱好者甚至大众用户。不过，人们的关注点一般都聚焦在开场的主题演讲（Keynote）上，认为其余活动都只是和职业开发者相关的技术交流。\n" +
                        "\n" +
                        "实际上，在 WWDC 的一百多场讲座（session）中，真正「捋起袖子写代码」的场景并不占大多数。相反，很多讲座都会介绍开发和设计的相关基础知识，并辅以大量生动有趣的演示。即使不从事开发工作的爱好者，也可以借观看 WWDC 讲座，快人一步地了解苹果最新的功能规划、生态布局，更加深入地理解技术背后的原理和动机。\n",
                isUser = true
            )
        )
    }
}
