package com.example.smartlab.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartlab.R
import com.example.smartlab.components.InputText
import com.example.smartlab.components.OnBoardDescription
import com.example.smartlab.ui.theme.AccentInactiveColor
import com.example.smartlab.ui.theme.InputBGColor
import com.example.smartlab.ui.theme.textDescription

@Composable
fun Confirmation(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 20.dp, end =20.dp, bottom = 56.dp)
    ){
    Button(onClick = {},
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
    Row {
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
        InputText(placeholder = "", modifier = Modifier.size(48.dp))
        Spacer(Modifier.width(10.dp))
    }
        Spacer(Modifier.height(20.dp))
        Text(text = "Отправить код повторно можно \n будет через 59 секунд",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = textDescription,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        )
    }
}

@Preview
@Composable
private fun ConfirmationView() {
    Confirmation()
}