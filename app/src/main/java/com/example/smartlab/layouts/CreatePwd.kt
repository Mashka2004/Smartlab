package com.example.smartlab.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.components.TextButton
import com.example.smartlab.ui.theme.textDescription

@Composable
fun CreatePwd(modifier: Modifier = Modifier) {
    Column (modifier = modifier
        .fillMaxSize()
        .padding(top = 40.dp, start = 20.dp, end = 20.dp, bottom = 80.dp)){
        TextButton(text = "Пропустить",
            modifier = Modifier
            .align(Alignment.End), fonSize = 15.sp)

        Spacer(Modifier.height(100.dp))
        Text(text = "Создайте пароль",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
            )
        Spacer(Modifier.height(16.dp))
        Text(text = "Для защиты ваших персональных данных",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = textDescription,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
private fun CreatePwdView() {
    CreatePwd()
}