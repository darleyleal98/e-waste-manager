package com.darleyleal.ewastemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darleyleal.ewastemanager.constants.AppRoutes
import com.darleyleal.ewastemanager.view.screens.HomeScreen
import com.darleyleal.ewastemanager.view.screens.LoginScreen
import com.darleyleal.ewastemanager.view.screens.RegisterScreen
import com.darleyleal.ewastemanager.view.screens.RegistrationFormScreen
import com.darleyleal.ewastemanager.view.screens.SearchTextFieldScreen
import com.darleyleal.ewastemanager.view.theme.EWasteManagerTheme
import com.darleyleal.ewastemanager.viewModel.AuthViewModel
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private val authViewModel: AuthViewModel by viewModels()
    private val registrationFormViewModel: RegistrationFormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            auth = Firebase.auth

            EWasteManagerTheme {
                NavHost(navController = navController, startDestination = AppRoutes.LOGIN) {
                    composable(route = AppRoutes.LOGIN) {
                        LoginScreen(
                            navController = navController, authViewModel = authViewModel
                        )
                    }
                    composable(route = AppRoutes.REGISTER) {
                        RegisterScreen(
                            navController = navController,
                            authViewModel = authViewModel
                        )
                    }
                    composable(route = AppRoutes.HOME) {
                        HomeScreen(
                            navController = navController,
                            registrationFormViewModel = registrationFormViewModel
                        )
                    }
                    composable(route = AppRoutes.SEARCH_FIELD) {
                        SearchTextFieldScreen(
                            navController = navController,
                            registrationFormViewModel = registrationFormViewModel
                        )
                    }
                    composable(
                        route = AppRoutes.ADD_REGISTRATION
                    ) {
                        RegistrationFormScreen(
                            navController = navController,
                            registrationViewModel = registrationFormViewModel
                        )
                    }
                }
            }
        }
    }
}