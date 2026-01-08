package com.kuvuni.compose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
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
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Greeting(
                name = "Patito Kuvuni",
                modifier = Modifier.padding(innerPadding)
            )
        }
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

/**
 * Un composable simple que muestra un mensaje de saludo.
 *
 * @param name El nombre a mostrar en el saludo.
 * @param modifier El modificador a aplicar al composable. Un `Modifier` se utiliza para decorar o agregar comportamiento a un composable de Jetpack Compose. En este caso, permite que el llamador personalice la apariencia o el diseño del `Text`.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Proporciona una vista previa del composable [Greeting] en Android Studio.
 *
 * La anotación `@Preview` permite a los desarrolladores ver sus composables en el
 * panel de diseño de Android Studio sin necesidad de ejecutar la aplicación en un
 * dispositivo o emulador.
 *
 * La anotación `@Preview` tiene varios parámetros que se pueden usar para personalizar la vista previa.
 * Por ejemplo:
 *  - `name`: para dar un nombre a la vista previa.
 *  - `showSystemUi`: para mostrar la interfaz de usuario del sistema (la barra de estado y la barra de navegación).
 *  - `device`: para previsualizar en un dispositivo específico (por ejemplo, "id:pixel_4").
 *  - `apiLevel`: para previsualizar en un nivel de API específico.
 *  - `locale`: para previsualizar en una configuración regional específica (por ejemplo, "es" para español).
 *  - `showBackground`: para mostrar un fondo predeterminado para el composable.
 *
 * También puedes crear tus propias anotaciones de "multiprevisualización" para combinar
 * múltiples configuraciones de `@Preview`. Esto es útil para previsualizar un composable
 * en diferentes dispositivos, tamaños de fuente o temas a la vez. Por ejemplo, podrías crear
 * una anotación `@DevicePreviews` que combine varias anotaciones `@Preview`:
 *
 * ```
 * @Preview(name = "Pixel 4", device = "id:pixel_4")
 * @Preview(name = "Pixel 7", device = "id:pixel_7")
 * annotation class DevicePreviews
 *
 * @DevicePreviews
 * @Composable
 * fun MyComposablePreview() { ... }
 * ```
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose1Theme {
        Greeting("Android")
    }
}
