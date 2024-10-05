package com.darleyleal.ewastemanager.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.darleyleal.ewastemanager.view.components.EWasteNameAndIconApp
import com.darleyleal.ewastemanager.viewmodel.AuthViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
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
        EWasteNameAndIconApp()
    }
}