package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import com.example.smartlab.components.PrimaryButton
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.EmailColor
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.InputFocusedBorderColor
import com.example.smartlab.ui.theme.InputStrokeColor

//Описание назначения класса - Класс Authorization используется для
// отображения экрана входа в приложение,
// где пользователи могут ввести свой адрес электронной почты.
// Этот экран является первым шагом для доступа к функциональности приложения.
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;

@Composable
  fun Authorization(modifier: Modifier = Modifier,OnClick:()->Unit) {
    Column(
        Modifier.padding(20.dp)
            .fillMaxSize()
            .padding(top = 59.dp, start = 20.dp, end =20.dp, bottom = 56.dp)
    ) {
        var email by remember { mutableStateOf("") }  // Состояние для хранения введенного email
        var isValidEmail by remember { mutableStateOf(false) } // Состояние для отслеживания валидности email
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$") // Регулярное выражение для проверки формата email
        Spacer(Modifier.size(59.dp))
        // Ряд для отображения иконки и заголовка
        Row {
            Image(ImageBitmap.imageResource(R.drawable.hello),null, modifier = Modifier.width(32.dp).height(32.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Добро пожаловать!",
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                lineHeight = 29.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(Modifier.size(20.dp))
        Text(
            text = "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 15.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400)
        )
        Spacer(Modifier.size(64.dp))
        Text(
            text = "Вход по E-mail",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = EmailColor
        )
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { newValue ->
                email = newValue
                isValidEmail = emailRegex.matches(newValue)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
            enabled = true,
            readOnly = false,
            placeholder = {
                Text(
                    text = "example@mail.ru",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp
                )
            },
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = InputBGColor,
                unfocusedContainerColor = InputBGColor,
                focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                focusedBorderColor = InputFocusedBorderColor,
                unfocusedBorderColor = InputStrokeColor,
                cursorColor = AccentColor
            ),
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(Modifier.size(32.dp))
        PrimaryButton(onClick={OnClick()}, text = "Далее",
            Enable = isValidEmail,
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(56.dp))
        }
    }