package com.example.primeiroprojeto

import android.os.Bundle
import android.util.Log
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiroprojeto.ui_recyclerview_adapter.ListaMaquinasAdapter
import java.math.BigDecimal


class MachineListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_list)
        Log.i(TAG, "$CHAMADA onCreate")

        //faço um toast para apresentar uma mensagem rapida na tela
        Toast.makeText(this, "Bem vindo ao Machine List - onCreate executado", Toast.LENGTH_SHORT)
            .show()

        //para trabalhar com um RecyclerView é preciso utilizar o .adapter -> Para isso foi criado uma classe para conter as configs desse adapter
        val rvListaMaq : RecyclerView = findViewById(R.id.rvListaMaq)
        rvListaMaq.adapter = ListaMaquinasAdapter(context = this, itens = listOf(
            Maquina(nome = "Envasadora 1l", linhaProd = "1 litro Clorados", horasParadas = BigDecimal(10.5)),
            Maquina(nome = "Tampador 1l", linhaProd = "1 litro Clorados", horasParadas = BigDecimal(16.5)),
            Maquina(nome = "Encaixotadora 1l", linhaProd = "1 litro Clorados", horasParadas = BigDecimal(1.5))
        ))
        //pode ser colocado o layoutManager aqui ou no xml, no caso vou manter o de la
//        rvListaMaq.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        private const val TAG = "tagInfo"
        private const val CHAMADA = "MachineListActivity ::"
    }
}