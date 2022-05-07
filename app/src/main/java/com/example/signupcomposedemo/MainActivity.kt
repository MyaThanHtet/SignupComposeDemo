package com.example.signupcomposedemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.signupcomposedemo.ui.theme.SignupComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SignupComposeDemoTheme {
                Navigation()
            }
        }
    }
}



