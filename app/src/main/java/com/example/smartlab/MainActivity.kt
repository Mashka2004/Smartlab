package com.example.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.smartlab.layouts.OnBoard
import com.example.smartlab.navigation.AppNavigation
import com.example.smartlab.ui.theme.SmartlabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            val pagerState = rememberPagerState(pageCount = {
                3
            })
            SmartlabTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HorizontalPager(state = pagerState) {page->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}