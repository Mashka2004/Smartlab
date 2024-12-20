package com.example.smartlab.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.textDescription
//Описание назначения класса - OnBoardDescription отображает текст описания в стилизованном виде
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun OnBoardDescription(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = textDescription,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    )
}
