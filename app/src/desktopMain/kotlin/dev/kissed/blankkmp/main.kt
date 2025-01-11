package dev.kissed.blankkmp

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "blank_kmp",
        state = WindowState(
            position = WindowPosition(alignment = Alignment.Center)
        )
    ) {
        ComposeMultiplatformAppUI(imageUrl = Constants.arnoldImageUrl)
    }
}
