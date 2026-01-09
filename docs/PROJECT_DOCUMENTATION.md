# Documentación del Proyecto: Jetpack Compose

Este documento detalla la estructura, componentes y conceptos aplicados en el proyecto `Compose1`, una aplicación de ejemplo para aprender los fundamentos de Jetpack Compose.

## 1. Estructura del Proyecto

El código fuente de la UI se ha organizado en varios paquetes dentro de `com.kuvuni.compose1.ui` para mantener el código limpio, modular y reutilizable.

-   **/ui/components**: Contiene `Composables` básicos y reutilizables, que son los "ladrillos" de nuestra interfaz (ej. `MyButton`, `MyTextField`). Cada componente está en su propio archivo.
-   **/ui/layouts**: Contiene ejemplos detallados de los `Composables` de organización de Jetpack Compose (ej. `Column`, `Row`, `ConstraintLayout`). Sirven como una guía de referencia rápida.
-   **/ui/functions**: Contiene `Composables` que representan funciones o secciones más complejas de la pantalla, combinando varios componentes básicos (ej. `ProfileScreen`, `ShowLoginScreen`).

## 2. Conceptos Fundamentales de Jetpack Compose

-   **`@Composable`**: Anotación que marca una función de Kotlin como una unidad de interfaz de usuario. Estas funciones describen cómo debe ser la UI, pero no cómo se crea. Compose se encarga de llamar a estas funciones para "dibujar" la pantalla.
-   **`Modifier`**: Un objeto que se pasa como parámetro a casi todos los `Composables`. Permite decorar o añadir comportamiento a la UI, como cambiar el tamaño, añadir `padding`, manejar clics o cambiar el color de fondo.
-   **`@Preview`**: Anotación que permite previsualizar un `Composable` directamente en el editor de Android Studio sin necesidad de ejecutar la aplicación en un dispositivo o emulador.
-   **Estado y `remember`**: El estado en Compose es cualquier valor que puede cambiar con el tiempo y afectar a la UI. Se declara usando `mutableStateOf`. Para que Compose "recuerde" este estado entre redibujos (recomposiciones), se usa la función `remember`.
-   **Elevación de Estado (State Hoisting)**: Es un patrón fundamental en Compose. Consiste en mover el estado de un `Composable` a un ancestro común para permitir que varios `Composables` lean y modifiquen ese mismo estado. En nuestro proyecto, el estado de los "favoritos" se eleva a `Compose1App` para que `HomeScreen` y `FavoritesScreen` puedan compartirlo.

## 3. Layouts (`ui/layouts`)

Estos `Composables` se usan para organizar otros `Composables` en la pantalla.

-   **`Column`**: Organiza a sus hijos en una secuencia vertical.
-   **`Row`**: Organiza a sus hijos en una secuencia horizontal.
-   **`Box`**: Apila a sus hijos uno encima del otro. Ideal para superponer elementos o alinearlos en una posición específica.
-   **`BoxWithConstraints`**: Una versión de `Box` que permite tomar decisiones de layout basadas en el espacio disponible (ancho y alto), ideal para UI responsivas.
-   **`ConstraintLayout`**: Permite crear layouts complejos definiendo relaciones (restricciones) entre los `Composables`, evitando anidar muchos `Column` y `Row`.
-   **`Scaffold`**: Proporciona la estructura básica de una pantalla de Material Design (barra superior, barra inferior, botón flotante, etc.).
-   **`LazyColumn` y `LazyRow`**: Para crear listas de elementos verticales y horizontales de forma eficiente, ya que solo renderizan los elementos visibles en pantalla.
-   **`LazyVerticalGrid`**: Similar a `LazyColumn`, pero para crear cuadrículas eficientes.
-   **`FlowRow`**: Organiza a sus hijos horizontalmente, pero si no hay espacio, "fluyen" a la siguiente línea. Perfecto para nubes de tags.

## 4. Componentes Básicos (`ui/components`)

Hemos creado una biblioteca de componentes reutilizables y personalizables.

-   **`MyButton`**: Un `Button` estándar.
-   **`MyTextField`**: Un `TextField` para la entrada de texto del usuario.
-   **`MyTopAppBar`**: Una `TopAppBar` para la parte superior de la pantalla.
-   **`MyBodyText` y `MyTitleText`**: `Composables` de `Text` con un estilo predefinido para consistencia.
-   **`MyCard`**: Un `Card` que sirve como contenedor con elevación.
-   **`MyCircularProgressIndicator`**: Un indicador de carga circular.
-   **`MyImage`**: Un `Composable` para mostrar imágenes desde los recursos `drawable`.
-   **`MyAlertDialog`**: Un cuadro de diálogo de alerta personalizable.
-   **`MySwitch`**: Un interruptor para opciones de verdadero/falso.
-   **`MyCheckbox`**: Una casilla de verificación.
-   **`MyRadioButton`**: Un botón de opción para selección única.
-   **`MySlider`**: Un control deslizante para seleccionar un valor.
-   **`MyDivider`**: Una línea para separar visualmente el contenido.
-   **`MyNavigationBar`**: La barra de navegación inferior.
-   **`MyDropdownMenu`**: Un menú desplegable (Spinner).
-   **`MyListItem`**: Un elemento de lista estándar de Material 3, con espacio para icono, título y subtítulo.

## 5. Funciones y Pantallas (`ui/functions` y `MainActivity.kt`)

-   **`ShowInfoCard`**: Muestra una tarjeta simple con título y cuerpo.
-   **`ShowLoginScreen`**: Un formulario de login básico.
-   **`ShowLoadingScreen`**: Una pantalla de carga simple.
-   **`ShowConfirmationDialog`**: Encapsula la lógica para mostrar un diálogo de alerta.
-   **`ProfileScreen`**: Una pantalla de perfil de usuario completa que demuestra cómo combinar múltiples componentes básicos para crear una interfaz compleja y realista.
-   **`HomeScreen`**: Muestra una lista de todos los elementos y permite marcarlos como favoritos.
-   **`FavoritesScreen`**: Muestra únicamente los elementos que han sido marcados como favoritos.

## 6. `MainActivity.kt`: El Orquestador

El archivo `MainActivity.kt` es el punto central de la aplicación y cumple varias funciones clave:

1.  **Punto de Entrada**: Es la `Activity` que lanza la aplicación.
2.  **`Compose1App`**: Es el `Composable` principal que contiene toda la lógica de la UI.
3.  **Gestión de Estado Centralizada**: Gestiona los estados que necesitan ser compartidos por múltiples pantallas, como la lista de `favoriteItems` y el destino de navegación actual (`currentDestination`). Este es un ejemplo perfecto de **elevación de estado**.
4.  **Navegación**: Utiliza un `NavigationSuiteScaffold` para la barra de navegación y un `when` para actuar como un "enrutador" (router), decidiendo qué pantalla (`Composable`) mostrar según el destino seleccionado.
5.  **Estructura de la Pantalla**: Usa un `Scaffold` para definir la estructura general de la pantalla, incluyendo un `SnackbarHost` para poder mostrar mensajes emergentes desde cualquier parte de la aplicación que tenga acceso al `scope` de corrutina.
