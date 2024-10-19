package com.darleyleal.ewastemanager.view.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.darleyleal.ewastemanager.R
import com.darleyleal.ewastemanager.constants.AppRoutes
import com.darleyleal.ewastemanager.model.Equipament
import com.darleyleal.ewastemanager.view.components.registration_form.DatePickerField
import com.darleyleal.ewastemanager.view.components.registration_form.DescriptionField
import com.darleyleal.ewastemanager.view.components.registration_form.EquipamentFabricantField
import com.darleyleal.ewastemanager.view.components.registration_form.EquipamentStatusField
import com.darleyleal.ewastemanager.view.components.registration_form.EquipamentTypeField
import com.darleyleal.ewastemanager.view.components.registration_form.EquipamentVoltage
import com.darleyleal.ewastemanager.view.components.registration_form.NameField
import com.darleyleal.ewastemanager.view.components.registration_form.SerieNumberField
import com.darleyleal.ewastemanager.view.components.registration_form.TelephoneNumberField
import com.darleyleal.ewastemanager.view.components.registration_form.WorkSectorField
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegistrationFormScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    registrationViewModel: RegistrationFormViewModel
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Novo registro",
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(0xFF202223),
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(
                    Color(0xFF202223)
                )
        ) {
            NameField(registrationViewModel = registrationViewModel)
            TelephoneNumberField(registrationViewModel = registrationViewModel)
            WorkSectorField(registrationViewModel = registrationViewModel)
            DatePickerField(registrationViewModel = registrationViewModel)
            EquipamentTypeField(registrationViewModel = registrationViewModel)
            DescriptionField(registrationViewModel = registrationViewModel)
            EquipamentStatusField(registrationViewModel = registrationViewModel)
            EquipamentFabricantField(registrationViewModel = registrationViewModel)
            EquipamentVoltage(registrationViewModel = registrationViewModel)
            SerieNumberField(registrationViewModel = registrationViewModel)
            Button(
                onClick = {
                    registrationViewModel.insert(
                        registrationViewModel.userName,
                        registrationViewModel.telephoneNumber,
                        registrationViewModel.workSector,
                        registrationViewModel.selectedDate,
                        registrationViewModel.equipamentType,
                        registrationViewModel.serieNumber,
                        registrationViewModel.equipamentVoltage,
                        registrationViewModel.equipamentStatus,
                        registrationViewModel.equipamentFabricant,
                        registrationViewModel.description,
                    )
                    Toast.makeText(
                        context,
                        "Equipamento cadastrado com sucesso", Toast.LENGTH_SHORT
                    ).show()
                    navController.navigate(AppRoutes.HOME)
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF32CD32)),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.salvar).uppercase(),
                    fontSize = 20.sp,
                    style = TextStyle(color = Color.White)
                )
            }
        }
    }
}