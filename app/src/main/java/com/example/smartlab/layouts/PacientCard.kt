package com.example.smartlab.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.components.InputText
import com.example.smartlab.components.OnBoardDescription
import com.example.smartlab.components.PrimaryButton
import com.example.smartlab.components.TextButton

@Composable
fun PacientCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(20.dp)
    ){
        Row() {
            Text(
                text = "Создание карты \nпациента",
                lineHeight = 28.sp,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            TextButton(
                text = "Пропустить",
                onClick = {},
                fonSize = 15.sp,
                modifier = Modifier.padding(top = 8.dp, end = 0.dp, start = 0.dp, bottom = 0.dp)
            )
        }
        Spacer(modifier.height(16.dp))
        OnBoardDescription(
            text = "Без карты пациента вы не сможете заказать анализы.\n" +
                    "В картах пациентов будут храниться результаты анализов вас и ваших близких."
        )
        Spacer(modifier.height(20.dp))
        InputText(placeholder = "Имя", modifier = Modifier.fillMaxWidth())
        Spacer(modifier.height(24.dp))
        InputText(placeholder = "Отчество", modifier = Modifier.fillMaxWidth())
        Spacer(modifier.height(24.dp))
        InputText(placeholder = "Фамилия", modifier = Modifier.fillMaxWidth())
        Spacer(modifier.height(24.dp))
        InputText(placeholder = "Дата рождения", modifier = Modifier.fillMaxWidth())
        Spacer(modifier.height(24.dp))
        Spacer(modifier.height(48.dp))
        PrimaryButton(
            text = "Создать",
            modifier = Modifier.fillMaxWidth().height(56.dp),
            Enable = false
        )


    }
}


@Preview
@Composable
private fun PacientCardView() {
    
}