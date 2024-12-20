package dev.kissed.blankkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import dev.kissed.blankkmp.data.ImageRepositoryImpl
import io.github.aakira.napier.Napier

class MainActivity : ComponentActivity() {
    
    private val viewModel: MainActivityViewModel by lazy { 
        MainActivityViewModel.Factory(ImageRepositoryImpl())
            .create(MainActivityViewModel::class.java)
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Napier.d("MainActivity.onCreate")
        
        setContent {
            val state by viewModel.states.observeAsState(null)
            ComposeMultiplatformAppUI(state)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    ComposeMultiplatformAppUI("")
}