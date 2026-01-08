package com.kuvuni.compose1.ui.functions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.components.MyAlertDialog
import com.kuvuni.compose1.ui.components.MyBodyText
import com.kuvuni.compose1.ui.components.MyButton
import com.kuvuni.compose1.ui.components.MyCard
import com.kuvuni.compose1.ui.components.MyCircularProgressIndicator
import com.kuvuni.compose1.ui.components.MyTextField
import com.kuvuni.compose1.ui.components.MyTitleText
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Muestra una tarjeta de información con un título y un cuerpo.
 *
 * @param title El título a mostrar en la tarjeta.
 * @param body El texto del cuerpo a mostrar en la tarjeta.
 * @param modifier El modificador a aplicar a la tarjeta.
 */
@Composable
fun ShowInfoCard(title: String, body: String, modifier: Modifier = Modifier) {
    MyCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            MyTitleText(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            MyBodyText(text = body)
        }
    }
}

/**
 * Muestra una pantalla de inicio de sesión simple.
 *
 * @param modifier El modificador a aplicar a la pantalla de inicio de sesión.
 */
@Composable
fun ShowLoginScreen(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyTitleText(text = "Inicio de Sesión")
        Spacer(modifier = Modifier.height(16.dp))
        MyTextField(
            value = username,
            onValueChange = { username = it },
            label = "Usuario",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        MyTextField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyButton(onClick = { /* Lógica de login */ }, text = "Entrar", modifier = Modifier.fillMaxWidth())
    }
}

/**
 * Muestra una pantalla de carga.
 *
 * @param modifier El modificador a aplicar a la pantalla de carga.
 */
@Composable
fun ShowLoadingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyCircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        MyBodyText(text = "Cargando...")
    }
}

/**
 * Muestra un diálogo de confirmación.
 *
 * @param showDialog Booleano para controlar la visibilidad del diálogo.
 * @param onDismiss La acción a realizar cuando se descarta el diálogo.
 */
@Composable
fun ShowConfirmationDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        MyAlertDialog(
            onDismissRequest = onDismiss,
            onConfirmation = onDismiss,
            dialogTitle = "Confirmación",
            dialogText = "¿Estás seguro de que quieres realizar esta acción?",
            icon = Icons.Filled.Help
        )
    }
}

@Preview(showBackground = true, name = "Composable Functions Preview")
@Composable
fun ComposableFunctionsPreview() {
    Compose1Theme {
        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShowInfoCard(
                title = "Tarjeta de Información",
                body = "Esta es una función composable que reutiliza nuestros componentes base."
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Para previsualizar el login, lo ponemos dentro de una tarjeta
            MyCard(modifier = Modifier.fillMaxWidth()) {
                ShowLoginScreen()
            }
            Spacer(modifier = Modifier.height(16.dp))

            MyButton(onClick = { showDialog = true }, text = "Mostrar Diálogo de Confirmación")

            // ShowLoadingScreen() // Comentado para no superponerlo en la preview, se puede descomentar para verlo

            ShowConfirmationDialog(showDialog = showDialog, onDismiss = { showDialog = false })
        }
    }
}
