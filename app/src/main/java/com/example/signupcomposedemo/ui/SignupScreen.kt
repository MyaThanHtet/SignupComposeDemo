package com.example.signupcomposedemo.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signupcomposedemo.R
import com.example.signupcomposedemo.Screen
import com.example.signupcomposedemo.SinUpTextFiled
import com.example.signupcomposedemo.SocialSignUpButton
import com.example.signupcomposedemo.ui.theme.AquaBlue
import com.example.signupcomposedemo.ui.theme.ButtonBlue
import com.example.signupcomposedemo.ui.theme.DeepBlue
import com.example.signupcomposedemo.ui.theme.TextWhite

@Composable
fun SignupScreen(
    navController: NavController
) {
    var textFullName by remember {
        mutableStateOf("")
    }
    var textPhone by remember {
        mutableStateOf("")
    }
    var textEmail by remember {
        mutableStateOf("")
    }
    var textPassword by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .background(DeepBlue, RectangleShape)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderTitle()

        TextFields(
            textFullName,
            textPhone,
            textEmail,
            textPassword,
            onChangeName = { textFullName = it },
            onChangeEmail = { textEmail = it },
            onChangePhone = { textPhone = it },
            onChangePassword = { textPassword = it }
        )

        SignUpButton(navController, textFullName, textEmail)
        Spacer(modifier = Modifier.height(48.dp))
        ThirdPartySignUp()
        FooterText()
    }

}

@Composable
fun HeaderTitle() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            text = "Create Account",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                fontSize = 30.sp,
                letterSpacing = 1.sp,
                color = TextWhite

            )
        )
        Text(
            modifier = Modifier
                .padding(top = 4.dp),
            text = "Sign up to get started",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                fontSize = 18.sp,
                letterSpacing = 1.sp,
                color = TextWhite
            )
        )
    }
}

@Composable
fun TextFields(
    name: String,
    phone: String,
    email: String,
    password: String,
    onChangeName: (String) -> Unit,
    onChangeEmail: (String) -> Unit,
    onChangePhone: (String) -> Unit,
    onChangePassword: (String) -> Unit

) {
    /* var textFullName by remember {
         mutableStateOf("")
     }
     var textPhone by remember {
         mutableStateOf("")
     }
     var textEmail by remember {
         mutableStateOf("")
     }
     var textPassword by remember {
         mutableStateOf("")
     }*/

    Column(
        modifier = Modifier

    ) {

        //fullName textFiled
        SinUpTextFiled(
            text = name,
            hint = "FullName",
            leadingIconRes = R.drawable.icon_person
        ) {
            onChangeName(it)
        }

        //email textFiled
        SinUpTextFiled(
            text = email,
            hint = "Email",
            leadingIconRes = R.drawable.icon_email
        ) {
            onChangeEmail(it)
        }

        //phone number textFiled
        SinUpTextFiled(
            text = phone,
            hint = "Phone Number",
            leadingIconRes = R.drawable.icon_phone
        ) {
            onChangePhone(it)
        }

        //password textFiled
        SinUpTextFiled(
            text = password,
            hint = "Password",
            leadingIconRes = R.drawable.icon_lock
        ) {
            onChangePassword(it)
        }
    }
}

@Composable
fun SignUpButton(navController: NavController, name: String, email: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 32.dp
            ),
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = ButtonBlue),
        onClick = {
            if (!(name == "" && email == "")) {
                navController.navigate(Screen.ProfileScreen.route + "/$name/$email")
            }


        }) {
        Text(
            text = "Sign Up",
            style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Medium)),
            fontSize = 18.sp,
            color = Color.White
        )
        )
    }
}

@Composable
fun ThirdPartySignUp() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier.width(64.dp),
                color = AquaBlue,
                thickness = 1.dp
            )

            Text(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                text = "Or Sign up with",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                    fontSize = 16.sp,
                    letterSpacing = 1.sp,
                    color = TextWhite
                )
            )

            Divider(
                modifier = Modifier.width(64.dp),
                color = AquaBlue,
                thickness = 1.dp
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                alignment = Alignment.CenterHorizontally
            ),
        ) {
            SocialSignUpButton(
                iconRes = R.drawable.google,
                contentDescription = "Sign up with Google"
            )
            SocialSignUpButton(
                iconRes = R.drawable.facebook,
                contentDescription = "Sign up with Facebook"
            )
        }
    }

}

@Composable
fun FooterText(context: Context = LocalContext.current) {
    val textBottom1 = "Already a member? "
    val textBottom2 = "Sign In"

    Row(
        modifier = Modifier.padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Text(
            text = textBottom1,
            color = TextWhite,
            fontFamily = FontFamily(
                Font(
                    R.font.roboto_regular,
                    weight = FontWeight.Medium
                )
            ),
            fontSize = 16.sp
        )

        Text(
            modifier = Modifier.clickable {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            },
            text = textBottom2,
            color = ButtonBlue,
            fontFamily = FontFamily(
                Font(
                    R.font.roboto_bold,
                    weight = FontWeight.Bold
                )
            ),
            fontSize = 16.sp
        )


    }
}





