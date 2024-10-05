package com.darleyleal.ewastemanager.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.ewastemanager.R

@Composable
fun EWasteNameAndIconApp(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier
            .padding(top = 84.dp)
            .size(50.dp),
        tint = Color.White,
        painter = painterResource(R.drawable.baseline_recycling_24),
        contentDescription = stringResource(R.string.logo_app)
    )
    Text(
        text = "e-Waste",
        color = Color.White,
        fontSize = 33.sp
    )
    Text(
        modifier = modifier.padding(start = 50.dp),
        text = "Manager", color = Color.White
    )
}