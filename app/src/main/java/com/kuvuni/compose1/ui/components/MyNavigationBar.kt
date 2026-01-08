package com.kuvuni.compose1.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Representa un único destino en la barra de navegación.
 * Se usa para desacoplar el Composable de una implementación específica.
 *
 * @param label La etiqueta de texto para el destino.
 * @param icon El icono para el destino.
 * @param route Una ruta o identificador único para la navegación.
 */
data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

/**
 * Una barra de navegación inferior de Material Design (Bottom Navigation Bar).
 * Es ideal para la navegación principal en pantallas de móviles.
 *
 * @param modifier El modificador que se aplicará a la barra de navegación.
 * @param items La lista de [NavigationItem] a mostrar.
 * @param currentRoute La ruta del destino actualmente seleccionado.
 * @param onItemClick La devolución de llamada que se invoca cuando se hace clic en un item, devolviendo su ruta.
 */
@Composable
fun MyNavigationBar(
    modifier: Modifier = Modifier,
    items: List<NavigationItem>,
    currentRoute: String,
    onItemClick: (String) -> Unit
) {
    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(item.route) },
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

@Preview(showBackground = true, name = "MyNavigationBar Preview")
@Composable
fun MyNavigationBarPreview() {
    // 1. Define una lista de destinos de ejemplo para la vista previa.
    val previewItems = listOf(
        NavigationItem("Inicio", Icons.Default.Home, "home"),
        NavigationItem("Favoritos", Icons.Default.Favorite, "favorites"),
        NavigationItem("Perfil", Icons.Default.Person, "profile")
    )
    // 2. Gestiona el estado del item seleccionado para que la vista previa sea interactiva.
    var selectedRoute by remember { mutableStateOf("home") }

    Compose1Theme {
        MyNavigationBar(
            items = previewItems,
            currentRoute = selectedRoute,
            onItemClick = { selectedRoute = it }
        )
    }
}
