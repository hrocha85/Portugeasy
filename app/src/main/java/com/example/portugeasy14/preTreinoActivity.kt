package com.example.portugeasy14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class preTreinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_treino)


        btnMainDicionario.setOnClickListener {

            var mIntent = Intent(this,treinoActivity::class.java)
            startActivity(mIntent)
        }

    }
}