package com.example.posto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcular(view : View){
          val editPrecoAlcool = precoAlcool.text.toString()
        val editPrecoGasolina  = precoGasolina.text.toString()
//        val editPrecoAlcool = findViewById<EditText>(R.id.precoAlcool)

        val validarCampos = validarCampos(editPrecoAlcool, editPrecoGasolina)
        if (validarCampos){
            val calcularMelhorPreco = calcularMelhorPreco(editPrecoAlcool, editPrecoGasolina)
        }else{
            txtResult.text = "Preencha os preços primeiro"
        }
    }

    private fun calcularMelhorPreco(editPrecoAlcool: String, editPrecoGasolina: String){
        val  valorAlcool = editPrecoAlcool.toDouble()
        val  valorGasolina = editPrecoGasolina.toDouble()

        val calculaPreco = valorAlcool / valorGasolina
        if (calculaPreco >= 0.7){
            txtResult.text = "melhor ultilizar gasolina"
        } else{
            txtResult.text = "melhor ultilizar alcool"
        }
    }

    private fun validarCampos(editPrecoAlcool: String, editPrecoGasolina: String): Boolean {
        var camposValidados = true
        if (editPrecoAlcool == null || editPrecoAlcool.equals("")){
            camposValidados = false
        }
        else if (editPrecoGasolina == null || editPrecoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }
}