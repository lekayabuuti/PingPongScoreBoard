package br.edu.ifsp.scl.sc3047733.pingpongscoreboard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScoreViewModel : ViewModel() {

    private val _placarA = MutableStateFlow(0)
    val placarA: StateFlow<Int> = _placarA.asStateFlow()

    private val _placarB = MutableStateFlow(0)
    val placarB: StateFlow<Int> = _placarB.asStateFlow()

    fun incrementarA() {
        _placarA.value = _placarA.value + 1
    }

    fun incrementarB() {
        _placarB.value = _placarB.value + 1
    }

    fun reiniciar() {
        _placarA.value = 0
        _placarB.value = 0
    }
}