# Guía de Estudio Detallada: Aprendiendo Jetpack Compose con el Proyecto Compose1

Este documento es una guía de estudio diseñada para que los alumnos aprendan los conceptos fundamentales y las mejores prácticas de Jetpack Compose a través del análisis y la expansión del proyecto `Compose1`.

---

## 1. El "Porqué" de Jetpack Compose: Un Nuevo Paradigma

Antes de sumergirnos en el código, es crucial entender qué es Compose y por qué representa un cambio tan importante.

**El Modelo Imperativo (XML tradicional):**
- **Cómo funciona:** Tú eres el responsable de inicializar los componentes (ej. `findViewById`), decidir *cuándo* actualizar la vista (ej. `textView.setText(...)`) y manejar manualmente los estados.
- **Desventajas:** A medida que la UI se vuelve compleja, la gestión del estado se convierte en una fuente común de errores (bugs).

**El Modelo Declarativo (Jetpack Compose):**
- **Cómo funciona:** Tú *describes* cómo debería ser la UI en un momento dado, basándote en un estado. No le dices a la UI *cómo* cambiar, solo *cuál* debería ser su apariencia. Cuando el estado cambia, el framework de Compose se encarga automáticamente de actualizar (recomponer) solo las partes de la UI que dependen de ese estado.
- **Ventajas:** Código más intuitivo, menos propenso a errores y una separación más clara entre el estado de la aplicación y la UI.

---

## 2. Conceptos Fundamentales de Jetpack Compose

Estos son los pilares sobre los que se construye toda la aplicación.

### `@Composable`: Bloques de Construcción de la UI
Una función marcada con `@Composable` es una pieza de tu interfaz. Puede ser tan simple como un texto o tan compleja como una pantalla entera.

-   **Reglas Clave:**
    -   Debe ser `Unit` (no devolver nada).
    -   Solo puede ser llamada desde otra función `@Composable`.

```kotlin
// Ejemplo de un Composable simple
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
```

### `Modifier`: El Decorador Universal
Un `Modifier` es una colección ordenada de decoraciones y comportamientos para un `Composable`. Es la forma estándar de personalizar la apariencia y la interacción.

-   **Encadenamiento:** Los modificadores se aplican en orden. Un `.padding()` antes de un `.background()` produce un resultado diferente a si se hace al revés.

```kotlin
Text(
    text = "Hola, Mundo",
    modifier = Modifier
        .padding(16.dp)                  // Añade espacio interior
        .background(Color.Yellow)        // Pone un fondo de color
        .fillMaxWidth()                  // Hace que ocupe todo el ancho posible
)
```

### `@Preview`: Visualiza sin Compilar
Permite ver una vista previa de tus `Composables` en el editor de Android Studio. Es una herramienta increíblemente poderosa para acelerar el desarrollo.

```kotlin
@Preview(showBackground = true, name = "Vista Previa del Saludo")
@Composable
fun GreetingPreview() {
    Compose1Theme {
        Greeting("Android")
    }
}
```

### Estado y `remember`: La Memoria de tu UI
El **estado** es cualquier valor que, al cambiar, debe provocar que la UI se actualice. En Compose, lo creamos con `mutableStateOf`.

-   **Recomposición:** Cuando el valor de un estado cambia, Compose vuelve a ejecutar (recompone) automáticamente todos los `Composables` que leen ese estado.
-   **`remember`**: Para que una variable de estado sobreviva a las recomposiciones, debemos envolver su creación con `remember`. De lo contrario, se reiniciaría a su valor inicial en cada redibujo.

```kotlin
// Ejemplo de un contador
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) } // 'count' es el estado

    Button(onClick = { count++ }) { // Al hacer clic, el estado cambia
        // Compose recompone este Text automáticamente cuando 'count' cambia
        Text(text = "Has hecho clic $count veces")
    }
}
```

### Elevación de Estado (State Hoisting): El Patrón Clave
Es el patrón más importante de Compose para crear componentes reutilizables y sin errores.

-   **Principio:** Un componente no debe tener su propio estado si ese estado necesita ser conocido o modificado por otros. En su lugar, el estado se "eleva" a un ancestro común.
-   **Flujo:** El estado fluye hacia abajo (del padre al hijo) y los eventos fluyen hacia arriba (del hijo al padre).

En nuestro proyecto, `favoriteItems` es un estado que se eleva a `Compose1App`. `HomeScreen` lo recibe para saber qué mostrar (estado abajo) y notifica a `Compose1App` cuando un favorito cambia (evento arriba).

```kotlin
// PATRÓN DE ELEVACIÓN DE ESTADO

// El padre gestiona el estado
@Composable
fun Screen() {
    var name by remember { mutableStateOf("") }
    // Pasa el estado y el evento al hijo
    NameInput(name = name, onNameChange = { newName -> name = newName })
}

// El hijo es "tonto" (stateless). Solo recibe datos y emite eventos.
@Composable
fun NameInput(name: String, onNameChange: (String) -> Unit) {
    TextField(value = name, onValueChange = onNameChange)
}
```

---

## 3. Guía de Referencia Rápida: Componentes y Layouts

### Layouts (`ui/layouts`)

-   **`Column`**: Apila elementos verticalmente. `verticalArrangement` controla el espaciado y `horizontalAlignment` la alineación.
-   **`Row`**: Apila elementos horizontalmente. `horizontalArrangement` controla el espaciado y `verticalAlignment` la alineación.
-   **`Box`**: Superpone elementos. `contentAlignment` los posiciona. Usa `Modifier.align()` en un hijo para un control individual.
-   **`Scaffold`**: La estructura de pantalla de Material Design. Proporciona ranuras (slots) para `topBar`, `bottomBar`, `floatingActionButton`, etc.
-   **`LazyColumn` / `LazyRow`**: Listas eficientes. Usa `items(miLista) { item -> ... }` para renderizar los elementos.

### Componentes (`ui/components`)

-   **`MyButton(onClick = { ... }, text = "Púlsame")`**: Un botón simple.
-   **`MyTextField(value = text, onValueChange = { text = it }, label = "Nombre")`**: Un campo de texto.
-   **`MyListItem(headlineText = "Título", supportingText = "Subtítulo")`**: Un elemento de lista estándar.
-   **`MySwitch(checked = activado, onCheckedChange = { activado = it }, text = "Opción")`**: Un interruptor.
-   **`MyDropdownMenu(label = "Elige", items = lista, selectedItem = sel, onItemSelected = { sel = it })`**: Un menú desplegable.
-   **`MyAlertDialog(onDismissRequest = { ... }, ...)`**: Un diálogo de alerta.

---

## 4. `MainActivity.kt`: El Orquestador de la Aplicación

Este archivo es el cerebro de nuestra aplicación. Sus responsabilidades son:

1.  **Punto de Entrada**: Es la `Activity` que inicia el flujo de la UI.
2.  **Fuente Única de Verdad (Single Source of Truth)**: Centraliza el estado que debe ser compartido por múltiples pantallas, como `currentDestination` (la pantalla actual) y `favoriteItems` (la lista de favoritos).
3.  **Manejo de Navegación**: Utiliza `NavigationSuiteScaffold` para construir la barra de navegación. El bloque `when(currentDestination)` actúa como un "enrutador", decidiendo qué pantalla `Composable` debe mostrarse.
4.  **Coordinación de Eventos Globales**: Gestiona el `SnackbarHostState` para que cualquier pantalla pueda solicitar la aparición de un `Snackbar`, centralizando la lógica de feedback al usuario.

---

## 5. Próximos Pasos y Ejercicios Sugeridos

Ahora que entiendes la estructura, ¡es tu turno de expandir la aplicación!

-   **Ejercicio 1 (Fácil):** Modifica `ProfileScreen` para que el nombre y la biografía no estén fijos, sino que vengan de un estado en `Compose1App`.
-   **Ejercicio 2 (Intermedio):** Crea una nueva pantalla `SettingsScreen.kt` en `ui/functions`. Añade un nuevo destino en el `enum AppDestinations` y haz que se muestre al navegar a él. En esta pantalla, usa `MyListItem` y `MySwitch` para simular ajustes.
-   **Ejercicio 3 (Avanzado):** Haz que al pulsar el `ListItem` de "Cerrar Sesión" en `ProfileScreen`, se muestre el `MyAlertDialog` de confirmación. Si el usuario confirma, muestra un `Snackbar` que diga "Sesión cerrada".
