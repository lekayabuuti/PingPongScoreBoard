package br.edu.ifsp.scl.sc3047733.pingpongscoreboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.sc3047733.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlacarScreen()
        }
    }
}

@Composable
fun PlacarScreen() {
    var placarA by remember { mutableStateOf(0) }
    var placarB by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Jogador A: $placarA")
        Button(onClick = {
            placarA++
        }) { Text("+1") }

        Text("Jogador B: $placarB")

        Button(onClick = {
            placarB++
        }) { Text("+1") }

        Button(onClick = {
            placarA = 0;
            placarB = 0
        }) { Text("Reiniciar partida") }

    }
}

@Preview(showBackground = true)
@Composable
fun ScoreBoardPreview() {
    PingPongScoreBoardTheme {
        PlacarScreen()
    }
}