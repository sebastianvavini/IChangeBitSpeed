package com.araujosoftware.ichangebitspeed

class Eu : Investimento() {

    /** Lista de Habilidades*/
    private var hab1 : Habilidade= Habilidade("Programação em Kótlin")
    private var hab2: Habilidade= Habilidade("Matemática")
    private var hab3:Habilidade= Habilidade("Tocar bateria")

    /** Lista de Compromissos*/
    private var pensaoAlimenticia:Compromisso= Compromisso("Pensao Alimenticia","dia 1, julho")
    private var creditoNubank:Compromisso=Compromisso("Pagamento da Fatura Nubank","")
    private var consignadoBB:Compromisso=Compromisso("consignado","74 vezes de R$ 1561,75")
    /** Lista de Pertences*/
    private var carro:Pertence= Pertence()
    private var notebook:Pertence= Pertence()
    private var quadroScrum:Pertence=Pertence()

   /** Lista de "amigos" (Investimentos)*/
    private var investimento1:Eu= Eu()
    private var investimento2:Eu= Eu()
    private var investimento3:Eu= Eu()




    fun iNeed(){

    }
    fun iHave(){

    }
    fun iDonated(){

    }

    fun somarInvestimentos(){

    }
}