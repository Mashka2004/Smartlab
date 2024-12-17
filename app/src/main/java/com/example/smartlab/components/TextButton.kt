package com.example.smartlab.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.smartlab.ui.theme.textButtonColor

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