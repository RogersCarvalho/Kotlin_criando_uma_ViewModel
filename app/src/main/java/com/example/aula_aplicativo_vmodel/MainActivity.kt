package com.example.aula_aplicativo_vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var txtcontador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    lateinit var nViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniDados()
        initclick()
    }


    private fun iniDados() {

        //instancia a classe MainViewModel
        nViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtcontador = findViewById(R.id.txtcontador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnmostrar)

        //Cada vez que a variável mContador for alterada o Observer vai ser notificado e
        //vai atribuir o valor novo ao txtcontador. Isso é feito automaticamente
        nViewModel.mContador.observe(this,Observer{valor -> txtcontador.setText(valor) })

    }

    private fun initclick() {
        btnDados.setOnClickListener { nViewModel.Contador() }
        btnMostrar.setOnClickListener{
            Toast.makeText( applicationContext,
                "Valor: ${nViewModel.mContador.value}",
                Toast.LENGTH_LONG).show() }
        }

    }







