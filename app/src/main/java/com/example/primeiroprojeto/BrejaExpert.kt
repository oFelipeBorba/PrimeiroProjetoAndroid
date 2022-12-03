package com.example.primeiroprojeto

class BrejaExpert {

    fun recebeBreja(spnBrejas : String): Array<String>{
        var listaDeOpcoes = arrayOf("")
        if (spnBrejas == "Pilsen"){
            listaDeOpcoes = arrayOf("Pilsner Urquell","Cerveja Pilsen Império","Cerveja Pilsen Fred Bier")
            return listaDeOpcoes
        }else if(spnBrejas == "Escura"){
            listaDeOpcoes = arrayOf("Cerveja Guinness Draught ","Cerveja Blumenau Macuca Imperial Stout","Cerveja Dádiva Imperial Stout Gimme Chocolate")
            return listaDeOpcoes
        }else if(spnBrejas == "Trigo"){
            listaDeOpcoes = arrayOf("Cerveja Paulaner Hefe-Weissbier Naturtrüb ","Cerveja Erdinger Pikantus","Cerveja Erdinger Dunkel")
            return listaDeOpcoes
        }
        return listaDeOpcoes
    }
}