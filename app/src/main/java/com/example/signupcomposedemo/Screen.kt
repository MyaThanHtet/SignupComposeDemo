package com.example.signupcomposedemo

sealed class Screen(val route:String){
    object SignUpScreen:Screen("signup")
    object ProfileScreen:Screen("profile")
}
