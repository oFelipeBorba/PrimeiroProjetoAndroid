package com.example.primeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class pgRecebeMensagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pg_recebe_mensagem)

        //uso o objeto intent para receber os dados junto ao metodo getStringExtra(passo a tag para dentro dela, posso pq foi criada fora da classe da outra activity)
        val mensagemRecebida = intent.getStringExtra(EXTRA_MESSAGE)
        //preciso de uma varivel para mostrar esse conteudo, no caso ela ira se conectar com o textVIew que foi criado na activity
        val textView = findViewById<TextView>(R.id.textViewMensagem).apply {
            text = mensagemRecebida
        }
    }
    fun observaBtnDois(view: View) {
        Log.i("TagBtnDois","Observa Btn Dois")
    }
}