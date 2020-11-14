package com.example.portugeasy14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_treino.*

class treinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino)


        btnTreinoDicionario.setOnClickListener {

            var mIntent = Intent(this,dicionarioActivity::class.java)
            startActivity(mIntent)
        }

    }
}