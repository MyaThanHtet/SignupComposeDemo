package com.example.signupcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signupcomposedemo.ui.theme.*

@Composable
fun SinUpTextFiled(
    text: String,
    hint: String,
    leadingIconRes: Int,
    onText: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 32.dp
            )
            .background(AquaBlue, RoundedCornerShape(25.dp)),
        value = text,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ButtonBlue,
            unfocusedBorderColor = AquaBlue,
            cursorColor = DeepBlue
        ),
        onValueChange = {
            onText(it)
        },

        singleLine = true,
        shape = RoundedCornerShape(25.dp),
        textStyle = signupTextFieldStyle(DeepBlue),
        placeholder = {
            Text(
                text = hint,
                style = signupTextFieldStyle(TextWhite)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIconRes),
                contentDescription = hint,
                tint = TextWhite
            )
        }
    )
}

@Composable
private fun signupTextFieldStyle(textColor: Color) = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Medium)),
    letterSpacing = 1.sp,
    color = textColor
)