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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.kuvuni.compose1.ui.components.MyListItem
import com.kuvuni.compose1.ui.theme.Compose1Theme
import kotlinx.coroutines.launch

/**
 * Es la única actividad de la aplicación y el punto de entrada principal.
 */
class MainActivity : ComponentActivity() {
    /**
     * Se llama cuando la actividad es creada por primera vez.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llama a la implementación de la superclase.
        super.onCreate(savedInstanceState)
        // Permite que la aplicación se dibuje de borde a borde de la pantalla.
        enableEdgeToEdge()
        // Establece el contenido de la actividad usando Jetpack Compose.
        setContent {
            // Aplica el tema personalizado de la aplicación.
            Compose1Theme {
                // Llama al Composable principal que contiene toda la lógica de la UI.
                Compose1App()
            }
        }
    }
}

/**
 * Composable principal que define la estructura de la aplicación, incluyendo la navegación.
 *
 * Contiene la lógica para la barra de navegación, el Scaffold (la estructura de la pantalla)
 * y el enrutamiento entre las diferentes pantallas.
 */
@PreviewScreenSizes
@Composable
fun Compose1App() {
    // Estado que recuerda el destino de navegación actual. `rememberSaveable` sobrevive a cambios de configuración (como rotaciones).
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    // Estado para controlar la visualización de Snackbars (mensajes emergentes).
    val snackbarHostState = remember { SnackbarHostState() }
    // Ámbito de corrutina para lanzar operaciones asíncronas (como mostrar un Snackbar) desde callbacks.
    val scope = rememberCoroutineScope()

    // Un layout de navegación adaptable que muestra una barra de navegación inferior en móviles y un raíl en pantallas más grandes.
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            // Itera sobre todos los destinos definidos en el enum AppDestinations.
            AppDestinations.entries.forEach { destination ->
                // Crea un elemento en la barra de navegación para cada destino.
                item(
                    icon = { Icon(destination.icon, contentDescription = destination.label) },
                    label = { Text(destination.label) },
                    // El item está seleccionado si su ruta coincide con el destino actual.
                    selected = destination == currentDestination,
                    // Al hacer clic, actualiza el estado del destino actual.
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        // Scaffold proporciona la estructura básica de Material Design (TopBar, BottomBar, etc.).
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            // Define el host que contendrá y mostrará los Snackbars.
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { innerPadding ->
            // Box que contiene el contenido principal de la pantalla.
            Box(modifier = Modifier.padding(innerPadding)) { // `innerPadding` es crucial para que el contenido no se solape con las barras.
                // Lógica de enrutamiento: muestra una pantalla diferente según el destino actual.
                when (currentDestination) {
                    AppDestinations.HOME -> HomeScreen(onItemClick = {
                        // Cuando se hace clic en un item de HomeScreen, lanza una corrutina.
                        scope.launch {
                            // Muestra un Snackbar con el texto del item clicado.
                            snackbarHostState.showSnackbar("Clic en: $it")
                        }
                    })
                    AppDestinations.FAVORITES -> PlaceholderScreen(text = "Pantalla de Favoritos")
                    AppDestinations.PROFILE -> PlaceholderScreen(text = "Pantalla de Perfil")
                }
            }
        }
    }
}

/**
 * La pantalla de inicio que muestra una lista de elementos desplazable.
 *
 * @param onItemClick Una función lambda que se invoca cuando se hace clic en un elemento de la lista.
 */
@Composable
fun HomeScreen(onItemClick: (String) -> Unit) {
    // Crea una lista de datos de ejemplo para mostrar.
    val sampleItems = (1..20).map { "Elemento de lista número $it" }

    // LazyColumn es una lista vertical eficiente (similar a RecyclerView), solo renderiza los items visibles.
    LazyColumn {
        // Itera sobre la lista de datos.
        items(sampleItems) { item ->
            // Usa nuestro Composable reutilizable para mostrar cada elemento.
            MyListItem(
                headlineText = item,
                supportingText = "Este es un texto de soporte",
                leadingContent = { Icon(Icons.Default.Person, contentDescription = "Icono de Persona") },
                trailingContent = { Icon(Icons.Default.Check, contentDescription = "Icono de Check") },
                // Llama a la función lambda pasada como parámetro cuando se hace clic en el item.
                onClick = { onItemClick(item) }
            )
        }
    }
}

/**
 * Una pantalla genérica que muestra un texto centrado.
 * Útil como marcador de posición para secciones no implementadas.
 *
 * @param text El texto a mostrar en el centro de la pantalla.
 * @param modifier Modificador para personalizar el layout.
 */
@Composable
fun PlaceholderScreen(text: String, modifier: Modifier = Modifier) {
    // Un Box que ocupa todo el espacio disponible.
    Box(
        modifier = modifier.fillMaxSize(),
        // Centra su contenido tanto vertical como horizontalmente.
        contentAlignment = Alignment.Center
    ) {
        Text(text)
    }
}

/**
 * Define los diferentes destinos de navegación de la aplicación de forma segura y centralizada.
 *
 * @param label La etiqueta de texto que se mostrará en la barra de navegación.
 * @param icon El icono que se mostrará en la barra de navegación.
 */
enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    /** Destino para la pantalla de inicio. */
    HOME("Home", Icons.Default.Home),

    /** Destino para la pantalla de favoritos. */
    FAVORITES("Favorites", Icons.Default.Favorite),

    /** Destino para la pantalla de perfil. */
    PROFILE("Profile", Icons.Default.AccountBox),
}
