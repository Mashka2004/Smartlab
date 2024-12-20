package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import com.example.smartlab.components.OnBoardDescription
import com.example.smartlab.components.OnBoardHeader
import com.example.smartlab.components.TextButton

//Описание назначения класса - Класс OnBoard предназначен для создания экрана онбординга,
// который помогает пользователям ознакомиться с основными функциями или особенностями приложения.
// Он может быть использован для представления информации о продукте, услуг или инструкций по использованию приложения.;
//Дата создания - 16.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun OnBoard(modifier: Modifier = Modifier,buttomText: String,headeText: String,descriptionText: String,
            dotsImageBitmap: ImageBitmap,illustration: ImageBitmap,onClick:()->Unit) {
    Column(modifier = modifier.fillMaxSize().padding(20.dp)) {

        Row {
            TextButton(text = buttomText, modifier = Modifier.weight(1f), onClick = {onClick()}, fonSize = 20.sp)
            Image(ImageBitmap.imageResource(R.drawable.shape__1_),null, modifier = Modifier.weight(1f).size(163.dp), alignment = Alignment.CenterEnd)
        }
        Spacer(Modifier.height(60.dp))
        OnBoardHeader(text = headeText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(26.dp))
        OnBoardDescription(text = descriptionText, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.height(40.dp))
        Image(dotsImageBitmap,null, modifier = Modifier.align(Alignment.CenterHorizontally).size(58.dp))
        Spacer(Modifier.weight(1f).height(106.dp))
        Image(illustration,null, modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxSize(0.8f))
    }
}
@Preview
@Composable
private fun OnBoardPreview() {
    OnBoard(
        buttomText = "Пропустить", headeText = "Анализы",
        descriptionText = "Экспресс сбор и получение проб",
        dotsImageBitmap = ImageBitmap.imageResource(R.drawable.group_1),
        illustration = ImageBitmap.imageResource(R.drawable.illustration),
        onClick = {})
}