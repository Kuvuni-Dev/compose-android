package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: FlowRow y FlowColumn
 *
 * `FlowRow` y `FlowColumn` son `Composables` de layout que son similares a `Row` y `Column`,
 * pero con una diferencia clave: si no hay suficiente espacio en el eje principal, los
 * elementos "fluyen" a la siguiente línea.
 *
 * `FlowRow` es ideal para crear nubes de "tags" o filtros, donde tienes un número
 * variable de elementos que quieres que se organicen de forma natural.
 *
 * ## Parámetros principales (`FlowRow`):
 * - `modifier`: Para personalizar el `FlowRow`.
 * - `horizontalArrangement`: Define el espaciado horizontal entre los elementos en la misma línea.
 * - `verticalArrangement`: Define el espaciado vertical entre las diferentes líneas.
 */
@Composable
fun FlowLayoutExample() {
    val tags = listOf(
        "Kotlin", "Jetpack Compose", "Android", "UI", "Layouts", "Programación",
        "Móvil", "Google", "Declarativo", "Jetpack", "Corrutinas", "Flow"
    )

    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Espacio horizontal entre tags
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio vertical entre filas de tags
    ) {
        tags.forEach { tag ->
            FilterChip(
                selected = false,
                onClick = { /* Acción al hacer clic en el tag */ },
                label = { Text(tag) }
            )
        }
    }
}

@Preview(showBackground = true, name = "FlowLayout Preview")
@Composable
fun FlowLayoutPreview() {
    Compose1Theme {
        FlowLayoutExample()
    }
}
