package com.darleyleal.ewastemanager.viewmodel

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.darleyleal.ewastemanager.constants.AppContants
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    var email by mutableStateOf("")
    var emailError by mutableStateOf("")

    var password by mutableStateOf("")
    var passwordError by mutableStateOf("")

    var emailIsValid by mutableStateOf(true)
    var passwordIsValid by mutableStateOf(true)

    fun validateFields(): Boolean {
        email = email.trim()
        password = password.trim()

        when {
            email.isEmpty() -> {
                emailError = AppContants.EMPTY_FIELDS
                emailIsValid = false
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                emailError = AppContants.EMAIL_IS_NOT_VALID
                emailIsValid = false
            }

            password.isEmpty() -> {
                passwordError = AppContants.EMPTY_FIELDS
                passwordIsValid = false
            }

            password.length < 6 -> {
                passwordError = AppContants.PASSWORD_NOT_VALIDATE
                passwordIsValid = false
            }

            else -> {
                emailIsValid = true
                passwordIsValid = true
            }
        }
        return emailIsValid && passwordIsValid
    }

    fun createUser(): Boolean {
        if (validateFields()) {
            auth.createUserWithEmailAndPassword(email, password)
            return true
        }
        return false
    }
}