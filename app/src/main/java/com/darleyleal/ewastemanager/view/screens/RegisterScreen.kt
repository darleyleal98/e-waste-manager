package com.darleyleal.ewastemanager.view.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.darleyleal.ewastemanager.R
import com.darleyleal.ewastemanager.constants.AppContants
import com.darleyleal.ewastemanager.viewmodel.AuthViewModel

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.run {
                verticalGradient(
                    colors = listOf(
                        Color(0xFF000000), Color(0xFF11D763)
                    )
                )
            }
        ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(R.string.cadastrar_nova_conta),
            fontSize = 18.sp, color = Color.White,
            modifier = modifier.padding(top = 104.dp)
        )

        var showPassword by remember { mutableStateOf(value = false) }
        var emailIsValid = authViewModel.emailIsValid
        var passwordIsValid = authViewModel.passwordIsValid
        val context = LocalContext.current

        TextField(
            value = authViewModel.email,
            onValueChange = {
                authViewModel.email = it
            },
            isError = !emailIsValid || authViewModel.email.isNotEmpty(),
            supportingText = {
                if (!emailIsValid) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = authViewModel.emailError,
                        color = MaterialTheme.colorScheme.onError
                    )
                }
            },
            label = {
                Text("E-mail", color = Color.Black)
            },
            leadingIcon = {
                Icon(
                    Icons.Default.MailOutline,
                    contentDescription = stringResource(R.string.personal_e_mail)
                )
            },
            trailingIcon = {
                if (!emailIsValid) {
                    Icon(
                        Icons.Filled.Error,
                        tint = MaterialTheme.colorScheme.error,
                        contentDescription = stringResource(R.string.error_message)
                    )
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        )

        TextField(
            value = authViewModel.password,
            onValueChange = {
                authViewModel.password = it
            },
            isError = !passwordIsValid,
            supportingText = {
                if (!passwordIsValid) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = authViewModel.passwordError,
                        color = MaterialTheme.colorScheme.onError
                    )
                }
            },
            label = { Text("Senha", color = Color.Black) },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Personal password")
            },
            trailingIcon = {
                when {
                    showPassword -> {
                        IconButton(onClick = { showPassword = false }) {
                            Icon(
                                imageVector = Icons.Filled.Visibility,
                                tint = Color.Black,
                                contentDescription = stringResource(R.string.hide_password)
                            )
                        }
                    }

                    !passwordIsValid -> {
                        IconButton(onClick = { !emailIsValid || !passwordIsValid }) {
                            Icon(
                                Icons.Filled.Error,
                                tint = MaterialTheme.colorScheme.error,
                                contentDescription = stringResource(R.string.error_message)
                            )
                        }
                    }

                    else -> {
                        IconButton(
                            onClick = { showPassword = true }) {
                            Icon(
                                imageVector = Icons.Filled.VisibilityOff,
                                tint = Color.Black,
                                contentDescription = stringResource(R.string.hide_password)
                            )
                        }
                    }
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
        )
        Button(
            onClick = {
                when {
                    authViewModel.validateFields() -> {
                        authViewModel.createUser()
                        Toast.makeText(
                            context, AppContants.USER_REGISTERED_SUCCESSFULLY,
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("home")
                    }

                    else -> {
                        Toast.makeText(
                            context, AppContants.ADD_ON_FAILURE_LISTENER,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF32CD32)),
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Salvar".uppercase(),
                fontSize = 20.sp,
                style = TextStyle(color = Color.White)
            )
        }
    }
}