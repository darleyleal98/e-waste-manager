package com.darleyleal.ewastemanager.view.components.registration_form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.ewastemanager.R
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel

@Composable
fun DescriptionField(
    modifier: Modifier = Modifier,
    registrationViewModel: RegistrationFormViewModel
) {
    var isValid by remember { mutableStateOf(true) }

    TextField(
        value = registrationViewModel.description,
        onValueChange = {
            registrationViewModel.description = it
            isValid = it.isNotEmpty()
        },
        isError = !isValid || registrationViewModel.description.isEmpty(),
        label = {
            Text(stringResource(R.string.descricao), color = Color.White)
        },
        supportingText = {
            if (!isValid) {
                Text(
                    text = "Esse campo é obrigatório!", color = Color.Red, fontSize = 16.sp,
                )
            }
        },
        trailingIcon = {
            if (!isValid) {
                Icon(
                    Icons.Filled.Error,
                    tint = Color.Red,
                    contentDescription = stringResource(R.string.error_message)
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    )
}