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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.scl.sc3047733.pingpongscoreboard.ui.theme.PingPongScoreBoardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PingPongScoreBoardTheme {
                PlacarScreen(viewModel = viewModel())
            }
        }
    }
}

@Composable
fun PlacarScreen(viewModel: ScoreViewModel) {
    val placarA by viewModel.placarA.collectAsStateWithLifecycle()
    val placarB by viewModel.placarB.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Jogador A: $placarA")
        Button(onClick = { viewModel.incrementarA() }) { Text("+1") }

        Text("Jogador B: $placarB")
        Button(onClick = { viewModel.incrementarB() }) { Text("+1") }

        Button(onClick = { viewModel.reiniciar() }) { Text("Reiniciar partida") }
    }
}

@Preview(showBackground = true)
@Composable
fun ScoreBoardPreview() {
    PingPongScoreBoardTheme {
        PlacarScreen(
            viewModel = viewModel()
        )
    }
}