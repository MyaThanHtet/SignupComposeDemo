package com.example.signupcomposedemo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SocialSignUpButton(
    iconRes: Int,
    contentDescription: String,
    context: Context = LocalContext.current
) {
    OutlinedButton(
        modifier = Modifier.size(46.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(8.dp),
        border = BorderStroke(0.dp, Color.White),
        elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
        onClick = {
            Toast.makeText(
                context,
                "Click",
                Toast.LENGTH_SHORT
            ).show()
        }) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
    }
}