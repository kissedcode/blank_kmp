package dev.kissed.blankkmp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ComposeMultiplatformAppUI(imageUrl: String? = null) {
    MaterialTheme {
        var imageShown by remember { mutableStateOf(false) }
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .clickable {
                    imageShown = true
                }
        ) {
            if (imageShown) {
                AsyncImage(
                    imageUrl, null,
                    Modifier.align(Alignment.Center)
                )
            } else {
                Text(
                    "Click to show image",
                    Modifier.align(Alignment.Center),
                    fontSize = 30.sp,
                )
            }
        }
    }
}