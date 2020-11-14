package com.example.portugeasy14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dicionario.*

class dicionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dicionario)

        btnDicionarioVoltar.setOnClickListener {


            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Você realmente deseja sair do dicionário?")
                .setPositiveButton("Sim"){_,_->
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)


                }

                .setNeutralButton("Cancelar"){_,_ ->}
                .setCancelable(false)
                .create()
                .show()

        }


    }
}