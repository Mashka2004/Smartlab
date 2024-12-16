package com.example.smartlab.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun OnBoardHeader(modifier: Modifier = Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )
}

@Preview
@Composable
private fun OnBoardHeaderPreview() {
    OnBoardHeader(text = "Заголовок")
}