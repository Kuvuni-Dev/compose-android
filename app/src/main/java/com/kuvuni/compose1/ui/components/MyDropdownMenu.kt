package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un menú desplegable (Dropdown Menu), comúnmente usado como un Spinner.
 * Se muestra dentro de un OutlinedTextField para un estilo consistente con Material 3.
 *
 * @param T El tipo de los elementos en la lista.
 * @param modifier El modificador que se aplicará al contenedor del Box.
 * @param label La etiqueta para el menú desplegable, que se muestra en el OutlinedTextField.
 * @param items La lista de elementos a mostrar en el menú.
 * @param selectedItem El elemento actualmente seleccionado.
 * @param onItemSelected La devolución de llamada que se invoca cuando se selecciona un elemento.
 */
@Composable
fun <T> MyDropdownMenu(
    modifier: Modifier = Modifier,
    label: String,
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        OutlinedTextField(
            value = selectedItem.toString(), // Muestra el elemento seleccionado
            onValueChange = { },
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true }), // Abre el menú al hacer clic
            readOnly = true, // Lo hace no editable
            trailingIcon = {
                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = "Flecha desplegable",
                    Modifier.clickable { expanded = !expanded }
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item.toString()) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "MyDropdownMenu Preview")
@Composable
fun MyDropdownMenuPreview() {
    val items = listOf("Opción 1", "Opción 2", "Opción 3", "Opción 4")
    var selectedItem by remember { mutableStateOf(items[0]) }

    Compose1Theme {
        MyDropdownMenu(
            modifier = Modifier.padding(16.dp),
            label = "Selecciona una opción",
            items = items,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}
