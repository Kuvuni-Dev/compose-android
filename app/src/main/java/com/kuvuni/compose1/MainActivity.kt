package com.kuvuni.compose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.kuvuni.compose1.ui.components.MyListItem
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Actividad principal de la aplicación.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose1Theme {
                Compose1App()
            }
        }
    }
}

/**
 * Composable principal de la aplicación.
 *
 * Un "Composable" es una función que describe una parte de la interfaz de usuario (UI).
 * Este composable en particular configura el scaffold de la suite de navegación y gestiona el destino actual.
 */
@PreviewScreenSizes
@Composable
fun Compose1App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = {
                        Icon(
                            destination.icon,
                            contentDescription = destination.label
                        )
                    },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                // Muestra la pantalla correcta según el destino actual
                when (currentDestination) {
                    AppDestinations.HOME -> HomeScreen()
                    AppDestinations.FAVORITES -> PlaceholderScreen(text = "Pantalla de Favoritos")
                    AppDestinations.PROFILE -> PlaceholderScreen(text = "Pantalla de Perfil")
                }
            }
        }
    }
}

/**
 * La pantalla de inicio, que muestra una lista de items.
 */
@Composable
fun HomeScreen() {
    val sampleItems = (1..20).map { "Elemento de lista número $it" }

    LazyColumn {
        items(sampleItems) { item ->
            MyListItem(
                headlineText = item,
                supportingText = "Este es un texto de soporte",
                leadingContent = {
                    Icon(Icons.Default.Person, contentDescription = "Icono de Persona")
                },
                trailingContent = {
                    Icon(Icons.Default.Check, contentDescription = "Icono de Check")
                },
                onClick = { /* Acción al hacer clic */ }
            )
        }
    }
}

/**
 * Una pantalla genérica para mostrar un texto como marcador de posición.
 *
 * @param text El texto a mostrar.
 */
@Composable
fun PlaceholderScreen(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text)
    }
}

/**
 * Enum que representa los diferentes destinos de la aplicación.
 *
 * @param label La etiqueta de texto para el destino.
 * @param icon El icono para el destino.
 */
enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    /**
     * Destino de la pantalla de inicio.
     */
    HOME("Home", Icons.Default.Home),

    /**
     * Destino de la pantalla de favoritos.
     */
    FAVORITES("Favorites", Icons.Default.Favorite),

    /**
     * Destino de la pantalla de perfil.
     */
    PROFILE("Profile", Icons.Default.AccountBox),
}
