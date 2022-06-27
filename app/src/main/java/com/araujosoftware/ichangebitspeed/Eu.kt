package com.araujosoftware.ichangebitspeed

class Eu : Investimento() {

    /** Lista de Habilidades*/
    private var hab1 : Habilidade= Habilidade("Programação em Kótlin")
    private var hab2: Habilidade= Habilidade("Matemática")
    private var hab3:Habilidade= Habilidade("Tocar bateria")

    /** Lista de Compromissos*/
    private var pensaoAlimenticia:Compromisso= Compromisso("Pensao Alimenticia","dia 1, julho")
    private var compromisso2:Compromisso=Compromisso("Pagamento da Fatura Nubank","")

    /** Lista de Pertences*/
    private var carro:Pertence= Pertence()
    private var notebook:Pertence= Pertence()

   /** Lista de Amigos*/
    private var amigo1:Eu= Eu()
    private var amigo2:Eu= Eu()
    private var amigo3:Eu= Eu()




    fun iNeed(){

    }
    fun iHave(){

    }
    fun iDonated(){

    }
}