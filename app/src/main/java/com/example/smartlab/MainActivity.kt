package com.example.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartlab.layouts.OnBoard
import com.example.smartlab.ui.theme.SmartlabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartlabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnBoard(buttonText="Пропустить", headerText = "Анализы"
                        ,decriptionText="Экспресс сбор и получение проб",
                        dotsImg = ImageBitmap.imageResource(R.drawable.group_1),
                        ilustrasion= ImageBitmap.imageResource(R.drawable.illustration),
                        modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
