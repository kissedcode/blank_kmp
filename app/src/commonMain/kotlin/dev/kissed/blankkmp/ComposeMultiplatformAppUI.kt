package dev.kissed.blankkmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ComposeMultiplatformAppUI(imageUrl: String? = null) {
    MaterialTheme {
        Box(Modifier.fillMaxSize()) {
            AsyncImage(
                imageUrl, null,
                Modifier.align(Alignment.Center)
            )    
        }
    }
}