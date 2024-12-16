package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartlab.R
import com.example.smartlab.components.OnBoardDescription
import com.example.smartlab.components.OnBoardHeader
import com.example.smartlab.components.TextButton


@Composable
fun OnBoard(modifier: Modifier = Modifier,buttonText:String,
            headerText:String,
            decriptionText:String,
            dotsImg:ImageBitmap,
            ilustrasion:ImageBitmap
) {
    Column(modifier = modifier.fillMaxSize().padding(20.dp)) {
        Row {
            TextButton(text = buttonText,
                modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.weight(1f))
            Image(ImageBitmap.imageResource(R.drawable.shape__1_),
                contentDescription = null,
                modifier = Modifier.weight(1f))
        }
        Spacer(Modifier.height(29.dp))
        OnBoardHeader(text = headerText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(26.dp))
        OnBoardDescription(text =decriptionText,
            modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(60.dp))
        Image(dotsImg, contentDescription = null, modifier= Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(106.dp))
        Image(ilustrasion, contentDescription = null,
            modifier= Modifier.align(Alignment.CenterHorizontally).fillMaxSize(0.8f))

    }
}
@Preview
@Composable
private fun OnBoardView () {
    OnBoard(buttonText="Пропустить", headerText = "Анализы"
        ,decriptionText="Экспресс сбор и получение проб",
        dotsImg = ImageBitmap.imageResource(R.drawable.group_1),
        ilustrasion=ImageBitmap.imageResource(R.drawable.illustration))
}