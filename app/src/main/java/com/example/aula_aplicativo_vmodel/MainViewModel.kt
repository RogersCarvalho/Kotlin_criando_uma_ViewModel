package com.example.aula_aplicativo_vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var contador: Int = 0

    var mContador = MutableLiveData<String>().apply { value = contador.toString() }

    private fun setContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador() {
        contador++
        if (contador > 5) {
            contador = 0
        }
        setContador()
    }

    fun Contador(){
        validaContador()
    }
}

