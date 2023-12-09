package com.example.webdigitaltask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.webdigitaltask.presentation.Car.CarScreen
import com.example.webdigitaltask.presentation.Car.CarViewModel
import com.example.webdigitaltask.presentation.login.LoginScreen
import com.example.webdigitaltask.presentation.login.LoginViewModel
import com.example.webdigitaltask.presentation.register.RegisterViewModel
import com.example.webdigitaltask.presentation.register.RegistrationScreen
import com.example.webdigitaltask.ui.theme.WebDigitalTAskTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebDigitalTAskTheme {
                // A surface container using the 'background' color from the theme
                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                LoginAndRegistration()

            }
        }
    }
}

@Composable
fun LoginAndRegistration() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_screen", builder = {
        composable("login_screen", content = {
            val viewmodel : LoginViewModel = hiltViewModel()
            LoginScreen(viewmodel = viewmodel,navController = navController) })
        composable(
            "register_screen",
            content = {
                val viewmodel : RegisterViewModel = hiltViewModel()
                RegistrationScreen(viewmodel = viewmodel, navController = navController)
            })

        composable(

            "home_screen", content = {
                val viewmodel : CarViewModel = hiltViewModel()
                val state = viewmodel.state.value
                CarScreen(state = state, viewModel = viewmodel, navController = navController)}
        )
    })

}

