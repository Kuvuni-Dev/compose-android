package com.kuvuni.compose1.ui.functions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.kuvuni.compose1.ui.components.MyButton
import com.kuvuni.compose1.ui.components.MyCard
import com.kuvuni.compose1.ui.components.MyTextField
import com.kuvuni.compose1.ui.components.MyTitleText
import com.kuvuni.compose1.ui.theme.Compose1Theme

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

@Preview(showBackground = true, name = "ShowLoginScreen Preview")
@Composable
fun ShowLoginScreenPreview() {
    Compose1Theme {
        MyCard(modifier = Modifier.fillMaxWidth()) {
            ShowLoginScreen()
        }
    }
}
