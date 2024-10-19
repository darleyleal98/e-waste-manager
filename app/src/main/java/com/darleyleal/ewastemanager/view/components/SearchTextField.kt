@file:Suppress("UNUSED_EXPRESSION")

package com.darleyleal.ewastemanager.view.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.darleyleal.ewastemanager.R
import com.darleyleal.ewastemanager.viewModel.RegistrationFormViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(modifier: Modifier = Modifier, viewModel: RegistrationFormViewModel) {

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var equipamentList = viewModel.listAllEquipaments().toList()

    Scaffold(
        topBar = {
        SearchBar(
            query = text,
            onQueryChange = { text = it },
            onSearch = {
                println("Performing search on query: $it")
            }, active = active,
            onActiveChange = { false },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    stringResource(R.string.icone_de_pesquisa)
                )
            },
            trailingIcon = {
                if (text.isNotBlank()) {
                    Icon(
                        modifier = modifier.clickable {
                            text = ""
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.icone_de_fechar)
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            shape = RoundedCornerShape(100.dp),
            placeholder = { Text(text = "O que você procura?") }
        ) {}
    }) {
        LazyColumn(modifier = Modifier.padding(top = 104.dp)) {
            items(equipamentList) {
                if (text.isNotEmpty()) {
                    val containsSoughtValue = remember(text) {
                        it.equipamentType?.contains(text, true)!! ||
                                it.userName?.contains(text, true) == true
                    }
                    if (containsSoughtValue) {
                        EquipamentSection(equipament = it)
                    }
                }
            }
        }
    }
}