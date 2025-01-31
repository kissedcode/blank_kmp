package dev.kissed.blankkmp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        ComposeMultiplatformAppUI(imageUrl = Constants.arnoldImageUrl)
    }
}