package com.example.portugeasy14

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login2.*

class loginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)


        //Executando o clique do botão entrar
        btnLogin2Entrar.setOnClickListener {

            //Capturar dados digitados pelo usuário
            val email = edtLogin2Email.text.toString().trim().toLowerCase()
            val senha = edtLogin2Senha.text.toString().trim()

            //Validação dos campos
            if (email.isEmpty()) {
                edtLogin2Email.error = "Campo obrigatório!"
                edtLogin2Email.requestFocus()
            } else if (senha.isEmpty()) {
                edtLogin2Senha.error = "Campo obrigatório!"
                edtLogin2Senha.requestFocus()
            } else {

                //Abrindo o arquivo de shared preferences

                val sharedPrefs = getSharedPreferences(
                    "cadastro_$email",
                    Context.MODE_PRIVATE
                )

                //Recuperar os dados do Shared Preferences

                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")


                if (email == emailPrefs && senha == senhaPrefs) {
                    // Caso a senha e o email esteja correta

                    // Exibindo o Toast (alerta curto) para o usuário logado
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()

                    // Criar a intent para ir para a Tela Main
                    val mIntent = Intent(this, MainActivity::class.java)

                    // passando
                    mIntent.putExtra("INTENT_EMAIL", email)

                    // Iniciar activity
                    startActivity(mIntent)

                    // Encerrar a Activity
                    finish()
                } else {
                    // Caso a senha ou o email esteja errado
                    Toast.makeText(this, "Email ou senha inválidos!", Toast.LENGTH_LONG).show()

                }
            }


        }

        btnLogin2Cadastrar.setOnClickListener {
            // Abrir a tela de cadastro
            val mIntent = Intent(this, cadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}