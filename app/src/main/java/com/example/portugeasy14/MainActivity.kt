package com.example.portugeasy14

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_treino.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val email = intent.getStringExtra("INTENT_EMAIL")

        //Abrindo o arquivo de shared preferences

        val sharedPrefs = getSharedPreferences( "cadastro_$email",
                Context.MODE_PRIVATE)

        //Recuperar os dados do Shared Preferences

        val nome = sharedPrefs.getString("NOME","Anônimo")
        val nivel = sharedPrefs.getString("NIVEL","Outros")

        txvMainNome.text="$nome"
        txvMainNivel.text= nivel



        btnManyTreino.setOnClickListener {

            var mIntent = Intent(this,preTreinoActivity::class.java)
            startActivity(mIntent)
        }


        btnMainDicionario.setOnClickListener {

            var mIntent = Intent(this,dicionarioActivity::class.java)
            startActivity(mIntent)
        }

    }
}