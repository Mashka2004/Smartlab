package com.example.smartlab.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.textHeaderColor
//Описание назначения класса - OnBoardHeader отображает заголовочный текст в стилизованном виде
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun OnBoardHeader(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = textHeaderColor,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
}
