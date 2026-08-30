package br.edu.ifsp.scl.sc3047733.pingpongscoreboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class ScoreViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        private const val CHAVE_PLACAR_A = "placarA"
        private const val CHAVE_PLACAR_B = "placarB"
    }

    val placarA: StateFlow<Int> = savedStateHandle.getStateFlow(CHAVE_PLACAR_A, 0)
    val placarB: StateFlow<Int> = savedStateHandle.getStateFlow(CHAVE_PLACAR_B, 0)

    fun incrementarA() {
        val atual = savedStateHandle.get<Int>(CHAVE_PLACAR_A) ?: 0
        savedStateHandle[CHAVE_PLACAR_A] = atual + 1
    }

    fun incrementarB() {
        val atual = savedStateHandle.get<Int>(CHAVE_PLACAR_B) ?: 0
        savedStateHandle[CHAVE_PLACAR_B] = atual + 1
    }

    fun reiniciar() {
        savedStateHandle[CHAVE_PLACAR_A] = 0
        savedStateHandle[CHAVE_PLACAR_B] = 0
    }
}