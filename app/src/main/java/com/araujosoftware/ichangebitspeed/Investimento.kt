package com.araujosoftware.ichangebitspeed

open class Investimento {
    
    private var nome:String=""
    private var bruto: Double=0.0
    private var liquido:Double=0.0
    private var precoDeCompra:Double=0.0

    private var precoPretendido:Double=0.0
    private var precoDeVenda:Double=0.0

    private var lucro:Double=0.0
    private var lucroPretendido=0.0

    private var pontos:Double=0.0
    private var milhas:Double=0.0

    private var diasDeTrabalho:Double=0.0
    private var horasDeTrabalho:Double=0.0
    private var precoDaHora:Double=0.0
    private var qtdLitrosComprados:Double=0.0
    private var precoDoLitro:Double=0.0
    private var autonomiaDoVeiculo:Double=0.1
    private var distanciaPercorrida:Double=0.0
    private var vezesPercorridas:Double=0.0
    private var houveDeslocamento:Boolean=true




    /** Indicadores economicos*/
    private var taxaSelic:Double=13.2
    private var ipca:Double=10.5
    private var igpm:Double=12.7

    fun setVezesPercorridas(vezes:Double){
        this.vezesPercorridas=vezes
    }
    fun setNome(novo:String){
        this.nome=novo
    }
    /**fun setAcumulado(valor:Double){
    this.acumulado=valor
    } */
    fun calculaTotais(){

        precoPretendido
        precoDeVenda= diasDeTrabalho*horasDeTrabalho*precoDaHora
        precoDeCompra=qtdLitrosComprados*precoDoLitro*distanciaPercorrida/autonomiaDoVeiculo
        this.bruto= precoDeVenda - precoDeCompra //somar com todos os bens inventariados

        this.liquido=precoDeVenda-precoDeCompra //então o lucro é igual ao líquido?
       // this.lucro=precoDeVenda-precoDeCompra //então o lucro é igual ao líquido?

        var distanciaEmKm=13.0
        this.distanciaPercorrida=this.diasDeTrabalho*distanciaEmKm


    }
    fun setLiquido(vl:Double){
        this.liquido=vl
    }
    fun setPrecoDeCompra(novo:Double){
        this.precoDeCompra=novo
    }
    fun setPrecoDeVenda(novoValor:Double){
        this.precoDeVenda=novoValor
    }
    fun setLucro(a:Double){
        this.lucro=a
    }
    fun setPontos(novos:Double){
        this.pontos=novos
    }
    fun setMilhas(milhas:Double){
        this.milhas=milhas
    }
    fun setDiasDeTrabalho(dias:Double){
        this.diasDeTrabalho=dias
    }
    fun setHorasDeTrabalho(h:Double){
        this.horasDeTrabalho=h
    }
    fun setPrecoDaHora(preco:Double){
        this.precoDaHora=preco
    }


    fun getVezesPercorridas():Double{
        return this.vezesPercorridas
    }
    fun getNome():String{
        return this.nome
    }
    fun getAcumulado():Double{
        return this.bruto
    }
    fun getLiquido():Double{
        return this.liquido
    }
    fun getPrecoDeCompra():Double{
        return this.precoDeCompra
    }
    fun getPrecoDeVenda():Double{
        return this.precoDeVenda
    }
    fun getLucro():Double{
        return this.lucro
    }
    fun getPontos():Double{
        return this.pontos
    }

    fun getMilhas():Double{
        return this.milhas
    }
    fun getDiasDeTrabalho():Double{
        return this.diasDeTrabalho
    }
    fun getHorasDeTrabalho():Double{
        return this.horasDeTrabalho
    }
    fun getPrecoDaHora():Double{
        return this.precoDaHora
    }
    fun getDistanciaPercorrida():Double{
        return this.distanciaPercorrida
    }

    fun printInvestimento(){

        println("Identificação do Investimento: ${this.getNome()}")
        println("Total Acumulado: ${this.getAcumulado()}")
        println("Total de Dinheiro Líquido: ${this.getLiquido()}")
        print("Total de Milhas: ${this.getMilhas()}")
        println("O Lucro Total foi de:${this.getLucro()}")
        println("Total de horas Trabalhadas: ${this.getDiasDeTrabalho()}")
        println("Total de Pontos no cartao de crédito ${this.getPontos()}")
        println("Total de dias Trabalhados: ${this.getDiasDeTrabalho()}")
        println("Total de Horas de Trabalho ${this.getHorasDeTrabalho()}")
        println("Preço da Hora de Trabalho: ${this.getPrecoDaHora()}")
        println("Preço de Compra (valor aportado) : ${this.getPrecoDeCompra()}")
        println("Preço de Venda do Investimento ${this.getPrecoDeVenda()}")


    }


}