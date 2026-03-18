package com.github.vinifagundess.navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MENU PRINCIPAL", modifier = Modifier.padding(bottom = 32.dp))


        Button(
            onClick = { navController.navigate("perfil") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.size(width = 200.dp, height = 48.dp)
        ) {
            Text("Perfil")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navController.navigate("pedidos") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.size(width = 200.dp, height = 48.dp)
        ) {
            Text("Pedidos")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navController.navigate("login") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            modifier = Modifier.size(width = 200.dp, height = 48.dp)
        ) {
            Text("Sair")
        }
    }
}