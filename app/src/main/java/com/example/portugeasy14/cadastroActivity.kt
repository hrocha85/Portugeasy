package com.example.portugeasy14

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class cadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //criar uma lista de opções para o spinner

        val listaNiveis = arrayListOf("Selecione seu nivel", "Nivel 1 - Iniciante","Nivel 2 - Confiante","Nivel 3 - Monezinha")

        // criar um adaptador para o spinner

        val niveisAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,listaNiveis
        )

        spnCadastroNivel.adapter = niveisAdapter

        btnCasdastroInscrevase.setOnClickListener {

            val nome = edtCadastroName.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val telefone = edtCadastroTel.text.toString().trim()
            val nivel = spnCadastroNivel.selectedItem.toString()

            // validação dos campos

            if (nome.isEmpty() || nivel == listaNiveis[0]) {

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG)
                    .show()
            } else {
                //neste pontos os campos foram preenchidos corretamente
                val sharedPrefs = getSharedPreferences(
                    "cadastro_$email",
                    Context.MODE_PRIVATE
                )

                //obtendo a referencia de edição do arquivo
                val editPrefs = sharedPrefs.edit()

                editPrefs.putString("NOME", nome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("TELEFONE", telefone)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("NIVEL", nivel)


                //Salvar os dados no arquivo de shared preferences

                editPrefs.apply()

                // abrir a tela main

                val mIntent = Intent(this, MainActivity::class.java)

                // passando dados atraves de intents

                mIntent.putExtra("INTENT_EMAIL", email)

                startActivity(mIntent)

                finishAffinity()

            }
        }


    }
}