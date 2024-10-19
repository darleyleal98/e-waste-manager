package com.darleyleal.ewastemanager.viewModel

import android.content.Context
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darleyleal.ewastemanager.constants.AppContants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel() : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    var email by mutableStateOf("")
    var emailError by mutableStateOf("")

    var password by mutableStateOf("")
    var passwordError by mutableStateOf("")

    var emailIsValid by mutableStateOf(true)
    var passwordIsValid by mutableStateOf(true)

    private val _loginResult = MutableStateFlow<Boolean?>(null)
    val loginResult: StateFlow<Boolean?> = _loginResult

    private val _createUserResult = MutableStateFlow<Boolean?>(null)
    val createUserResult: StateFlow<Boolean?> = _createUserResult

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

    fun createUser() {
        if (validateFields()) {
            viewModelScope.launch {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    try {
                        when {
                            it.isSuccessful -> {
                                _createUserResult.value = true

                            }

                            else -> {
                                _createUserResult.value = false
                            }
                        }
                    } catch (exception: FirebaseAuthUserCollisionException) {
                        Log.i("CreateUserError", "Usuário já foi cadastrado")
                    }
                }
            }
        } else {
            _createUserResult.value = false
        }
    }

    fun signIn() {
        if (validateFields()) {
            viewModelScope.launch {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    when {
                        it.isSuccessful -> {
                            _loginResult.value = true
                        }

                        else -> {
                            _loginResult.value = false
                        }
                    }
                }
            }
        } else {
            _loginResult.value = false
        }
    }

    fun resetLoginResult() {
        _loginResult.value = null
    }

    fun resetCreateUser() {
        _createUserResult.value = null
    }
}