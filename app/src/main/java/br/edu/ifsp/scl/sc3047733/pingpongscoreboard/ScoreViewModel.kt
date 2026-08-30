package br.edu.ifsp.scl.sc3047733.pingpongscoreboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var placarA by mutableStateOf(0)
        private set

    var placarB by mutableStateOf(0)
        private set

    fun incrementarA() {
        placarA++
    }

    fun incrementarB() {
        placarB++
    }

    fun reiniciar() {
        placarA = 0
        placarB = 0
    }
}