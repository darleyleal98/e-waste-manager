package com.darleyleal.ewastemanager.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.darleyleal.ewastemanager.constants.AppRoutes
import com.darleyleal.ewastemanager.view.components.EquipamentSection
import com.darleyleal.ewastemanager.view.components.SwipeToModifyContainer
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    registrationFormViewModel: RegistrationFormViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "e-Waste",
                        color = Color.Green,
                        fontSize = 28.sp,
                        modifier = modifier.padding(top = 10.dp, start = 16.dp, bottom = 16.dp)
                    )
                    Text(
                        modifier = modifier.padding(top = 44.dp, start = 62.dp),
                        text = "Manager",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate(AppRoutes.SEARCH_FIELD) }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Barra de pesquisa",
                            modifier = modifier.padding(top = 10.dp, end = 16.dp),
                            tint = Color.Green
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF202223))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(AppRoutes.ADD_REGISTRATION)
                },
                modifier = modifier.padding(bottom = 32.dp),
                containerColor = Color(0xFFA1887F)
            ) {
                Icon(
                    Icons.Filled.Add, "Add icon", tint = Color.White
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color(0xFF202223)
                ),
            verticalArrangement = Arrangement.spacedBy((-32).dp),
            contentPadding = PaddingValues(vertical = 100.dp)
        ) {
            var equipamentList = registrationFormViewModel.listAllEquipaments()

            items(equipamentList, key = { it.id }) {
                SwipeToModifyContainer(
                    item = it,
                    onDelete = {
                        registrationFormViewModel.delete(it)
                    },
                    content = {
                        EquipamentSection(equipament = it)
                    }
                )
            }
        }
    }
}