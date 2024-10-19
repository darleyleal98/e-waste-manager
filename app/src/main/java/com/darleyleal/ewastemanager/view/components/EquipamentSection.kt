package com.darleyleal.ewastemanager.view.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darleyleal.ewastemanager.model.Equipament

@Composable
fun EquipamentSection(
    equipament: Equipament
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        Modifier
            .fillMaxWidth()
            .heightIn(132.dp)
            .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            .clickable {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            equipament.equipamentType?.let {
                Text(
                    text = it,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(800),
                    maxLines = 1,
                    color = Color.DarkGray,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = "Status:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    maxLines = 2,
                    color = Color.Black
                )
                equipament.equipamentStatus?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        maxLines = 2,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = "Data de cadastro:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    maxLines = 2,
                    color = Color.Black
                )
                equipament.date?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        maxLines = 2,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = expanded,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Text(
                    text = "Detalhes do equipamento",
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Usuário responsável:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.userName?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Telefone:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.telephoneNumber?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Setor de trabalho:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.workSector?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Fabricante:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.equipamentFabricant?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Número de série:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.serieNumber?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Voltagem:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        maxLines = 2,
                        color = Color.Black
                    )
                    equipament.equipamentVoltage?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            maxLines = 2,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp, bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}