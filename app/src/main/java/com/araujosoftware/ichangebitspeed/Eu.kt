package com.araujosoftware.ichangebitspeed



class Eu() : Investimento() {

    var habilidades: MutableSet<Habilidade> = mutableSetOf()

    var compromissos:MutableSet<Compromisso> = mutableSetOf()

    var pertences: MutableSet <Pertence> = mutableSetOf()

    fun adicionaPertence (pertence: Pertence){
        pertences.add(pertence)
    }



    var investimentos:MutableSet<Investimento> = mutableSetOf()
    fun adicionarInvestimento(investimento: Investimento){
            investimentos.add(investimento)
    }



    fun iNeed(){

    }
    fun iHave(){

    }
    fun iDonated(){

    }


    fun somarInvestimentos(){
       // val soma= investimento1.getLiquido()+investimento2.getLiquido()+investimento3.getLiquido()

    }


}