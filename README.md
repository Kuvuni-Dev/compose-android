# Proyecto Educativo: Aprendiendo Jetpack Compose

Este repositorio contiene un proyecto de Android construido con Jetpack Compose, diseñado específicamente como una herramienta educativa para alumnos que están dando sus primeros pasos en el desarrollo de UI declarativas en Android.

El proyecto ha sido estructurado para ser claro, modular y fácil de entender, sirviendo como un caso práctico de las mejores prácticas en Compose.


---

## 🚀 Características y Conceptos Demostrados

Este proyecto no es solo una aplicación, sino una demostración práctica de los pilares de Jetpack Compose:

-   **UI Declarativa:** Código que describe *qué* quieres mostrar, no *cómo*.
-   **Biblioteca de Componentes Reutilizables:** Más de 15 componentes modulares y personalizables en el paquete `ui/components`.
-   **Gestión de Estado (State Management):** Uso de `remember`, `rememberSaveable` y el patrón de **elevación de estado (state hoisting)** para una gestión de datos predecible y sin errores.
-   **Navegación Funcional:** Un sistema de navegación simple pero efectivo entre las pantallas de `Home`, `Favorites` y `Profile`.
-   **Layouts Avanzados:** Ejemplos prácticos de todos los `Composables` de layout importantes, desde `Column` y `Row` hasta `ConstraintLayout` y `LazyVerticalGrid`.
-   **Theming:** Implementación de un tema básico con `MaterialTheme` (colores, tipografía).
-   **Interacción con el Usuario:** Manejo de clics, cambios de estado y feedback al usuario a través de `Snackbar`.

---

## 📂 Estructura del Proyecto

La organización del código está pensada para ser escalable y fácil de navegar:

-   `MainActivity.kt`: El **orquestador** de la aplicación. Controla el estado global y la navegación.
-   `/ui/components`: Contiene los **"ladrillos"** de la UI. Componentes genéricos y reutilizables.
-   `/ui/layouts`: Una **guía de referencia** con ejemplos de cada tipo de layout en Compose.
-   `/ui/functions`: **Pantallas o secciones** que combinan varios componentes básicos para crear una funcionalidad completa.
-   `/docs`: Contiene la **guía de estudio detallada** del proyecto.

---

## 📚 Guía de Estudio Completa

Para una inmersión profunda en cada concepto, componente y decisión de arquitectura tomada en este proyecto, consulta nuestra guía de estudio completa:

➡️ **[Guía Maestra de Estudio: Dominando Jetpack Compose](./docs/PROJECT_DOCUMENTATION.md)**

Este documento contiene explicaciones detalladas, ejemplos de código adicionales y ejercicios prácticos para que puedas aplicar lo aprendido.

---

## 🛠️ Cómo Empezar

1.  **Clona el repositorio:**
    ```bash
    git clone https://github.com/Kuvuni-Dev/compose-android.git
    ```
2.  **Abre el proyecto** en la última versión de [Android Studio](https://developer.android.com/studio).
3.  **Sincroniza Gradle** para descargar todas las dependencias necesarias.
4.  **Ejecuta la aplicación** en un emulador o en un dispositivo físico.

¡Y listo! Ya puedes empezar a explorar el código y a experimentar.

---

## 💪 ¡Ahora es tu turno!

La mejor forma de aprender es haciendo. Te animamos a que intentes resolver los ejercicios propuestos en la [guía de estudio](./docs/PROJECT_DOCUMENTATION.md#5-próximos-pasos-y-ejercicios-sugeridos). ¡Rompe cosas, experimenta y, sobre todo, diviértete programando con Compose!
