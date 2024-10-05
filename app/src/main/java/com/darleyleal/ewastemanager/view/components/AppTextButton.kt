package com.darleyleal.ewastemanager.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun AppTextButton(modifier: Modifier = Modifier, text: String, navController: NavHostController) {
    TextButton(onClick = { navController.navigate("register") }) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            modifier = modifier.padding(top = 8.dp)
        )
    }
}