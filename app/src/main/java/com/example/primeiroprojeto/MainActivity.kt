package com.example.primeiroprojeto

import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

//variavel constante que e enviada no putExtra, passo o nome do pacote como identificador unico ?!
const val EXTRA_MESSAGE = "com.example.primeiroprojeto.MENSAGEM"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("tagInfo", "MainActivity em onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "$CHAMADA_MAIN Entrada em onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "MainActivity::Entrada em onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "MainActivity::Entrada em onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "MainActivity::Entrada em onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "MainActivity::Entrada em onDestroy")
    }

    companion object {
        private const val TAG = "tagInfo"
        private const val CHAMADA_MAIN = "MainActivity::"
    }

    //metodo que e chamado ao clicar no botao,foi definido no atributo do botao onClick
    fun enviarMensagem(view: View) {
        //cria um log de informacao, classe log, chamo de i (info), a tag dele e difinida assim como a msg (Nao faz nada alem de informar o click do botao)
        Log.i("btnClicado", "Metodo enviarMensagem chamado.")
        //criando um intent que e um obj que prove em tempo de execucao uma conexao entre dois componentes diferentes, como activities
        //crio variavel imutavel, chamo de editText. uso um metodo do android pra buscar a view pelo id, e no diamante coloco o tipo da view
        //dentro dos () informo o id dessa view passando antes a notacao R.id. -> Desse modo a view foi vinculada a variavel
        val editText = findViewById<EditText>(R.id.etMensagem)
        //crio uma variavel para armazenar a mensagem - e capturo o texto inserido dentro da view editText (passando para string)
        val mensagem = editText.text.toString()

        //-----------------------------------------------------------------ACTION_SEND - INTENT----------------------------------------------------------------
//        //Criando uma intent para enviar uma mensagem (SMS, WPP, EMAIL)
//        val intent = Intent(Intent.ACTION_SEND).apply {
//            type = "text/plain"
//            putExtra(EXTRA_TEXT,mensagem)
//        }
//        if (intent.resolveActivity(packageManager) != null) {
//            startActivity(intent)
//        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------

        //criando a intencao de realizar uma acao, passo para uma variavel
        //dentro do obj intent que esta sendo criado e precisamos passar a referencia da activity que estamos trabalhando (this) e a activity que vamos interagir (a pgRecebeMensagemActivity)
        //algumas classes do android ainda funcionam em java, entao precisamos converter essa class kotlin p java com ::class.java
        val intent = Intent(this, PgRecebeMensagemActivity::class.java).apply {
            //utilizando o metodo .apply do intent, passamos uma mensagem para proxima activity(usando o putExtra())
            //putExtra recebe dois valores, o primeiro a tag da mensagemUnica que sera enviada para activity (criei ela fora da classe)
            //o segundo e o que desejamos de fato enviar
            putExtra(EXTRA_MESSAGE, mensagem)
        }
        //Agora e invocado o metodo que e responsavel por chamar a prox activity e passar as informacoes de interesse
        startActivity(intent)
        //agora a segunda activity que ira receber a informacao da primeira intent no caso no arquivo da outra activity
        //foi criado uma variavel dentro da funcao onCreate dessa outra activity
    }

    fun acessaTelaDois(view: View) {
        Log.i("btnClicado", "Chamada para tela dois")
        val intent = Intent(this, PgRecebeMensagemActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoStopwatch(view: View) {
        val intent = Intent(this, StopwatchActivity::class.java)
        startActivity(intent)
    }
}