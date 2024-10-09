package com.immortalidiot.wishescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.wishescompose.navigation.MainScreenFlow
import com.immortalidiot.wishescompose.providers.LocalSnackbarHostState
import com.immortalidiot.wishescompose.ui.theme.BackgroundEnd
import com.immortalidiot.wishescompose.ui.theme.BackgroundStart
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )

        super.onCreate(savedInstanceState)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            val navHostController = rememberNavController()

            CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    BackgroundStart,
                                    BackgroundEnd
                                )
                            )
                        )
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    MainScreenFlow(navHostController = navHostController)
                }
            }
        }
    }
}
