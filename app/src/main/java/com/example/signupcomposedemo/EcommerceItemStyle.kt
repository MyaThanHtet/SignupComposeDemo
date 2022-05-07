package com.example.signupcomposedemo

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signupcomposedemo.ui.theme.AquaBlue
import com.example.signupcomposedemo.ui.theme.BlueViolet2
import com.example.signupcomposedemo.ui.theme.TextWhite

// Row style for options
@Composable
fun EcommerceItemStyle(
    item: EcommerceData,
    context: Context = LocalContext.current.applicationContext
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
                Toast
                    .makeText(context, item.title, Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Icon
        Icon(
            modifier = Modifier
                .size(32.dp),
            imageVector = item.icon,
            contentDescription = item.title,
            tint = AquaBlue
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // Title
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Medium)),
                        color = TextWhite
                    )
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Sub title
                Text(
                    text = item.subTitle,
                    style = TextStyle(
                        fontSize = 14.sp,
                        letterSpacing = (0.8).sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        color = AquaBlue
                    )
                )

            }

            // Right arrow icon
            Icon(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = item.title,
                tint = BlueViolet2
            )
        }

    }
}