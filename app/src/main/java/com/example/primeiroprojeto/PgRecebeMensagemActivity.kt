package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class PgRecebeMensagemActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pg_recebe_mensagem)
        configurarListeners()

        Log.i(TAG, "$CHAMADA_MAIN Entrada em onCreate")

        //uso o objeto intent para receber os dados junto ao metodo getStringExtra(passo a tag para dentro dela, posso pq foi criada fora da classe da outra activity)
        val mensagemRecebida = intent.getStringExtra(EXTRA_MESSAGE)
        //preciso de uma varivel para mostrar esse conteudo, no caso ela ira se conectar com o textVIew que foi criado na activity
        val textView = findViewById<TextView>(R.id.textViewMensagem).apply {
            text = mensagemRecebida
        }
    }

    private fun configurarListeners() {
        configurarBtnVoltar()
    }

    fun configuraBtnExibidor(view: View) {
        val btnInvisivel = findViewById<Button>(R.id.btnTelaReceber)
        btnInvisivel.visibility = View.VISIBLE
    }

    private fun configurarBtnVoltar() {
        val btnInvisivel = findViewById<Button>(R.id.btnTelaReceber)
        btnInvisivel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onDestroy")
    }

    companion object {
        private const val TAG = "tagInfo"
        private const val CHAMADA_MAIN = "pgRecebeMensagemActivity::"
    }
    fun observaBtnDois(view: View) {
        Log.i("TagBtnDois","Observa Btn Dois")
    }
}