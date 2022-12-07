package com.example.primeiroprojeto.ui_recyclerview_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiroprojeto.Maquina
import com.example.primeiroprojeto.R

//usando o construtor inicial criado uma variavel do tipo lista de maquinas, recebe os obj da class Maquina
class ListaMaquinasAdapter(
    private val context : Context,
    private val itens : List<Maquina>
) : RecyclerView.Adapter<ListaMaquinasAdapter.ViewHolder>() {

    //criado manual - um ViewHolder do tipo RecyclerView que recebe a view do viewHolder class
    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        fun vincula(item: Maquina) {
            val nomeMaq = itemView.findViewById<TextView>(R.id.tvNomeMaq)
            nomeMaq.text = item.nome
            val linhaProd = itemView.findViewById<TextView>(R.id.tvLinhaProd)
            linhaProd.text = item.linhaProd
            val horasParadas = itemView.findViewById<TextView>(R.id.tvHorasParadas)
            horasParadas.text = item.horasParadas.toPlainString()
        }
    }

    //Necessario implementar onCreateViewHolder + onBindViewHolder + getItemCount
    //onCreateVireHolder cria a referencia do viewHolder, responsavel por pegar cada view apresentada e fazer processo de bind (ele mantem a view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.machine_item, parent, false)
        return ViewHolder(view)
    }

    //onBindViewHolder metodo que indica qual o item está colocando dentro do adapter, indicando a posição e holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itens[position]
        holder.vincula(item)
    }

    //getItemCount determina para o adapter quantos itens serão apresentados dentro dele
    override fun getItemCount(): Int {
        return itens.size //retorno apenas o tamanho da lista 'itens'
    }

}
