package com.example.pix.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pix.R
import com.example.pix.presentation.navigation.FlickrNavigationHost
import com.example.pix.presentation.ui.theme.PixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        enableEdgeToEdge()
        setContent {
            PixTheme {
                FlickrNavigationHost()
            }
        }
    }
}