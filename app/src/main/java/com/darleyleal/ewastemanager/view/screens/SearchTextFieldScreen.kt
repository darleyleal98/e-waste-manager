package com.darleyleal.ewastemanager.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.darleyleal.ewastemanager.view.components.SearchTextField
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel

@Composable
fun SearchTextFieldScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    registrationFormViewModel: RegistrationFormViewModel
) {
    SearchTextField(viewModel = registrationFormViewModel)
}