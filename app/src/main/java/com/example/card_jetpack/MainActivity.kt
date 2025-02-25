package com.example.card_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.card_jetpack.ui.theme.Card_jetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Card_jetpackTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomBar() }
                ) { innerPadding ->
                    MainContent(innerPadding)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Game Hub", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1E1E1E))
    )
}

@Composable
fun BottomBar() {
    BottomAppBar(
        containerColor = Color(0xFF1E1E1E),
        contentColor = Color.White
    ) {
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Info, contentDescription = "Info")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite, contentDescription = "Favoritos")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.ShoppingCart, contentDescription = "Comprar")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "Jogar")
        }
    }
}

@Composable
fun MainContent(innerPadding: PaddingValues) {
    val games = listOf(
        "The Legend of Zelda: Breath of the Wild",
        "God of War",
        "Red Dead Redemption 2",
        "Cyberpunk 2077",
        "Elden Ring",
        "Halo Infinite"
    )

    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(games) { game ->
            GameCard(game)
        }
    }
}

@Composable
fun GameCard(gameName: String) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2E2E2E),
        ),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .padding(8.dp)
            .size(width = 300.dp, height = 120.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = gameName,
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}