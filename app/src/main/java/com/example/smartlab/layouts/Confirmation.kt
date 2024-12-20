package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartlab.R
import com.example.smartlab.components.PrimaryButton
import com.example.smartlab.ui.theme.AccentColor
import com.example.smartlab.ui.theme.AccentInactiveColor
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.InputFocusedBorderColor
import com.example.smartlab.ui.theme.InputStrokeColor
import kotlinx.coroutines.delay

//Описание назначения класса - Класс Confirmation используется для отображения экрана,
// на котором пользователи могут ввести код, полученный по электронной почте или через SMS.
// Такой экран часто встречается в процессе регистрации, восстановления пароля или верификации учетной записи.
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun Confirmation(modifier: Modifier = Modifier, navController: NavController, onClick:()->Unit) {
    val code="111111";
    val focusRequesters = remember { List(6){ FocusRequester() }}
    val textField = remember { mutableStateListOf("","","","","","") } // Состояние для хранения цифр кода подтверждения

    var timerSeconds by remember { mutableStateOf(60) } // Состояние для хранения оставшегося времени таймера

    var isTimerRunning by remember { mutableStateOf(true) } // Состояние для отслеживания, работает ли таймер


    LaunchedEffect(key1 = isTimerRunning) {
        if (isTimerRunning) {
            while (timerSeconds > 0) {
                delay(1000L)
                timerSeconds--
            }
            isTimerRunning = false
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 20.dp, end =20.dp, bottom = 56.dp)
    ){
    Button(onClick = {onClick()},
        modifier = Modifier.padding(0.dp),
        colors = ButtonDefaults.buttonColors(
        containerColor = InputBGColor,
        contentColor = Color.White,
        disabledContentColor = Color.White,
        disabledContainerColor = AccentInactiveColor
    ),
        shape = RoundedCornerShape(9.dp)
    ){
    Image(imageVector = ImageVector.vectorResource(R.drawable.vector),null)
    }
    Spacer(Modifier.height(132.dp))
    Text(text = "Введите код из E-mail",
        fontSize = 17.sp,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
    )
        Spacer(Modifier.height(20.dp))
        // Ряд полей ввода для кода подтверждения
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            textField.forEachIndexed{index,value->
                OutlinedTextField(
                    value=value, onValueChange = {newValue->
                        textField[index] = newValue
                        if(textField.joinToString("")==code){
                            navController.navigate("password")
                        }
                        if(newValue.length==1&&index<textField.lastIndex){
                            focusRequesters[index+1].requestFocus()
                        }
                    },modifier = Modifier.size(48.dp) .focusRequester(focusRequesters[index]).padding(top = 1.dp)
                    , colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = InputBGColor,
                        unfocusedContainerColor = InputBGColor,
                        focusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                        unfocusedPlaceholderColor = Color.Black.copy(alpha = 0.5f),
                        focusedBorderColor = InputFocusedBorderColor,
                        unfocusedBorderColor = InputStrokeColor,
                        cursorColor = AccentColor
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    )
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        // Условный вывод текста таймера или кнопки повторной отправки
        if (isTimerRunning) {
            Text(
                text = "Отправить код повторно можно\nбудет через $timerSeconds секунд",
                style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            PrimaryButton(modifier = Modifier, text = "Выслать код повторно",onClick = {
                timerSeconds = 60
                isTimerRunning = true
            })
        }
    }
}

@Preview
@Composable
private fun ConfirmationView() {

}