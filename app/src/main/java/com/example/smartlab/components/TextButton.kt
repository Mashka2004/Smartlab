package com.example.smartlab.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.smartlab.ui.theme.textButtonColor
//Описание назначения класса - TextButton создает стилизованный текстовый элемент, который можно использовать как кнопку
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun TextButton(modifier: Modifier = Modifier,fonSize: TextUnit, text: String,onClick: () -> Unit = {}) {
    Text(
        text = text,
        modifier = modifier
            .clickable { onClick() },
        color = textButtonColor,
        fontSize = fonSize,
        fontWeight = FontWeight.SemiBold,
    )
}