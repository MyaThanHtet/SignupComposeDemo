package com.example.signupcomposedemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.signupcomposedemo.ui.ProfileScreen
import com.example.signupcomposedemo.ui.SignupScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SignUpScreen.route
    ) {
        composable(route = Screen.SignUpScreen.route) {
            SignupScreen(navController = navController)
        }
        composable(
            route = Screen.ProfileScreen.route+"/{name}/{email}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("email") {
                    type = NavType.StringType
                },
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!

            ProfileScreen(
                name = name,
                email = email
            )
        }
    }


}

