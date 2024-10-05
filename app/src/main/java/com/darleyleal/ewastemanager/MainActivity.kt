package com.darleyleal.ewastemanager

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darleyleal.ewastemanager.view.screens.HomeScreen
import com.darleyleal.ewastemanager.view.screens.LoginScreen
import com.darleyleal.ewastemanager.view.screens.RegisterScreen
import com.darleyleal.ewastemanager.view.theme.EWasteManagerTheme
import com.darleyleal.ewastemanager.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private val authViewModel : AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            auth = Firebase.auth

            EWasteManagerTheme {
                NavHost(navController = navController, startDestination = "login") {
                    composable(route = "login") {
                        LoginScreen(navController = navController, authViewModel = authViewModel)
                    }
                    composable(route = "register") {
                        RegisterScreen(navController = navController, authViewModel = authViewModel)
                    }
                    composable(route = "home") {
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }
}