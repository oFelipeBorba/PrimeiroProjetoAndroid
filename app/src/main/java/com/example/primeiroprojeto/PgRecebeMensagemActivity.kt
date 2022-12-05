package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class PgRecebeMensagemActivity : AppCompatActivity() {

    val brejaExpert = BrejaExpert()
    private lateinit var btnInvisivel:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pg_recebe_mensagem)

        btnInvisivel = findViewById(R.id.btnTelaReceber)

        //verifica se ele e nulo
        if (savedInstanceState != null){
            Log.i(TAG,"Entrei no savesInstance")
            //verifica se tem a var tag_view e se ela e verdadeira - se ela for true ela mantem o view como visible (isso significa que tem informações para serem recuperadas)
            if(savedInstanceState.getBoolean(TAG_VIEW)){
                Log.i(TAG,"Entrei no savesInstance para alterar o View")
                btnInvisivel.visibility = View.VISIBLE
            }
        }
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

    fun recebeBrejas(view: View){
        val spinner = findViewById<Spinner>(R.id.spnBrejas) //crio a variavel que ta atrelada ao spinner
        val textViewBreja = findViewById<TextView>(R.id.tvShowBreja) //crio a variavel que ta atrelada ao textView
        val valorSpinner = spinner.selectedItem //crio a variavel que recebe o valor selecionaod no spinner, chamando ele.selectedItem
        val repassaBrejaExpert = brejaExpert.recebeBreja(valorSpinner.toString())
        textViewBreja.apply { //aplico no textView um text com o valorSpinner(na vdd uma lista referente ao valor selecionado criada em BrejaExpert) passado para string
            text = repassaBrejaExpert.joinToString()
        }

    }


    fun configuraBtnExibidor(view: View) {
        //Como o btnInvisivel será usado em mais de um local no código, irei crialo em escopo global
        //e depois o setContentView no onCreate eu faço a ligação dele com o findViewById
//        val btnInvisivel = findViewById<Button>(R.id.btnTelaReceber)
        btnInvisivel.visibility = View.VISIBLE
    }

    //Criado uma constante para identificar o btn - no companion

    //Usando um metodo que salva as informações para nao serem perdidas
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //aqui usamos a val criada e passamos o estado que queremos (no caso estamos comparando o estado do botao atual com o da view - retorna true ou false)
        outState.putBoolean(TAG_VIEW, btnInvisivel.visibility == View.VISIBLE )
        //Alem disso sera necessario criar no onCreate um if que controla se o savesInstanceState esta null
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
        private const val TAG_VIEW = "btn_visibility"
        private const val TAG_BREJA = "recupera_breja"
    }

    fun observaBtnDois(view: View) {
        Log.i("TagBtnDois","Observa Btn Dois")
    }
}

