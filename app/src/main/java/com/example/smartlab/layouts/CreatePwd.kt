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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smartlab.R
import com.example.smartlab.components.TextButton
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.textDescription
//Описание назначения класса - CreatePwd реализует экран для создания пароля,
// состоящего из 4 цифр. Пользователю предлагается ввести пароль, нажимая на кнопки с цифрами.
//Дата создания - 17.12.2024;
//Автор создания - Капотова Мария;
@Composable
fun CreatePwd(modifier: Modifier = Modifier,navController:NavController) {
    val PassFieldValues = remember { mutableStateListOf("", "", "", "") }
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
        Spacer(Modifier.height(56.dp))
        Row(modifier.align(Alignment.CenterHorizontally)) {
            PassFieldValues.forEachIndexed { index, value ->
                if(value=="") { // Отображение индикаторов ввода пароля
                    Image(painter = painterResource(R.drawable.ellipse_2),null,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(16.dp))
                }else{ // Заполненный кружок, если цифра введена
                    Image(painter = painterResource(R.drawable.ellipse_1),null,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(
                                16.dp
                            ))
                }
            }
        }
        Spacer(modifier.height(60.dp))
        // Клавиатура для ввода пароля
        Column(modifier =Modifier.align(Alignment.CenterHorizontally)) {
            var counter = 1
            for(i in 1..3){
                Spacer(modifier.height(24.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterHorizontally)){
                    for (j in 1..3){
                        val textButton = counter.toString()
                        Button(onClick = {
                            if(PassFieldValues.size <=4){
                                val index = PassFieldValues.indexOfFirst { it.isEmpty()}
                                PassFieldValues[index]= textButton
                            }
                        },
                            modifier=Modifier.size(80.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = InputBGColor,
                                contentColor = Color.Black,
                            ) ) {
                            Text(text = counter.toString(),
                                fontSize = 24.sp) }
                        counter++
                    }
                }
            }
            Spacer(modifier.height(24.dp))
            Row(modifier=Modifier.align(Alignment.End)) {
                Button(onClick = {
                    // Добавляем цифру в пароль, если еще не введены все цифры
                    if(PassFieldValues.size<=4){
                        val index = PassFieldValues.indexOfFirst { it.isEmpty()}
                        PassFieldValues[index]=0.toString()
                    }},
                    modifier=Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = InputBGColor,
                        contentColor = Color.Black,
                    ) ) {
                    Text(text = "0",
                        fontSize = 24.sp) }
                Spacer(modifier = Modifier.width(24.dp))
                // Добавляем 0 в пароль, если еще не введены все цифры
                Button(onClick = {
                    PassFieldValues.forEach{value->
                        if(value!=""){
                            val lastIndex = PassFieldValues.indexOfLast { it != "" }
                            PassFieldValues[lastIndex] = "";
                        }
                    }

                },
                    modifier=Modifier.size(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =Color.Transparent,
                        contentColor = Color.Black,
                    ) ) {
                    Image(painter = painterResource(R.drawable.del_icon),null)
                }
                var pass = PassFieldValues.joinToString("")

                if(pass.length == 4){
                    pass="";
                    navController.navigate("patientCard")
                }
            }
        }
    }
}
@Preview
@Composable
private fun CreatePwdView() {

}