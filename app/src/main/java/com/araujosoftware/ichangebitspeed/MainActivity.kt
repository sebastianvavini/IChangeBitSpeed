package com.araujosoftware.ichangebitspeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.araujosoftware.ichangebitspeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityMainBinding


    private lateinit var nome: EditText
    private lateinit var acumulado: EditText
    private lateinit var liquido: EditText
    private lateinit var custoDoTempoAplicado:TextView


    private lateinit var custoDeRecursosConsumidos: TextView
    private lateinit var valorDoAporte :TextView
    private lateinit var precoPretendido: EditText

    //private lateinit var lucro: EditText abandona a ideia de lucro. Focar em equity. No capital acumulado
    private lateinit var pontos: EditText
    private lateinit var milhas: EditText
    private lateinit var horasDeTrabalho: EditText
    private lateinit var diasDeTrabalho: EditText
    private lateinit var precoDaHora: EditText
    private lateinit var precoUnidadeMedida:EditText

    private lateinit var totalDeKMsPercorridos: EditText
    private lateinit var vezesPercorridas:EditText

    private lateinit var localDeOrigemDoMotorista:EditText
    private lateinit var localDeEmbarqueDoPassageiro:EditText
    private lateinit var localDeDesembarqueDoPassageiro:EditText


    private lateinit var autonomiaDoVeiculo: EditText //autonomia

    private lateinit var qtdUnidades: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        fazerBinding()

        setContentView(binding.root)
        addOnClickListeners()


    }
    private fun  fazerBinding(){
        nome = binding.editTextNome
        acumulado = binding.editTextBruto
        liquido = binding.editTextLiquido
        custoDoTempoAplicado= binding.textViewCustoDoTempoAplicado

        custoDeRecursosConsumidos = binding.textviewCustoDeRecursosConsumidos
        precoPretendido = binding.editTextPrecoPretendido
        precoUnidadeMedida= binding.editTextPrecoPorUnidadeDeMedida
        pontos = binding.editTextPontos
        milhas = binding.editTextMilhas

        //lucro =binding.editTextLucro // abandonada a ideia de lucro. Focar em equitiy

        horasDeTrabalho = binding.editTextHorasPorDia
        diasDeTrabalho = binding.editTextDiasDeTrabalho
        precoDaHora = binding.editTextPrecoHora

        totalDeKMsPercorridos = binding.editTextKmsPercorridos //Distancia percorrida
        autonomiaDoVeiculo = binding.editTextAutonomiaDoVeiculo //autonomia do veiculo
        qtdUnidades = binding.editTextQtdUnidades


        valorDoAporte = binding.textviewValorDoAporte



    }

    private fun addOnClickListeners(){
        binding.imageSave.setOnClickListener(this)
        custoDoTempoAplicado.setOnClickListener(this)
       // binding.radioSimDeslocamento.setOnClickListener(this)
        binding.radioNaoDeslocamento.setOnClickListener(this)
        binding.radioNaoPagou.setOnClickListener(this)
        binding.textviewCustoDeRecursosConsumidos.setOnClickListener(this)
        valorDoAporte.setOnClickListener(this)

    }

    override fun onClick(p: View) {
        if (p.id == R.id.image_save) {
            println("Ouvindo...")
            salvar()
        }
        if(p.id==R.id.textView_custo_do_tempo_aplicado){
            calculeCustoDeTempoAplicado()
        }
        if(p.id==R.id.radio_sim_deslocamento){

        }
        if(p.id==R.id.radio_nao_deslocamento){

            println(" Some Perguntas desnecessarias")
            binding.linearLayoutTrajeto.isVisible=false
            binding.linearlayoutFoiEmVeiculoProprio.isVisible=false
            binding.textviewAutonomia.isVisible=false
            binding.linearLayoutAutonomia.isVisible=false


        }
        if(p.id==R.id.radio_nao_pagou){
            binding.linearLayoutQtdUnidadesCompradas.isVisible=false
            binding.linearLayoutPrecoUnidadeComprada.isVisible=false
        }
        if(p.id==R.id.textview_custo_de_recursos_consumidos){
            calculeCustoDeRecursosConsumidos()
        }
        if(p.id==R.id.textview_valor_do_aporte){

            println("VALOR DO APORTE CALCULANDO...")
            var horasTrab=calculeCustoDeTempoAplicado()
            var consumo = calculeCustoDeRecursosConsumidos()

            var resultado = horasTrab + consumo
            var formatado= "%.2f".format(resultado)
            var valorString= "R$ ${formatado}"

            valorDoAporte.setText(valorString)
        }
    }

    private fun calculeCustoDeRecursosConsumidos():Double{
        var trajeto= totalDeKMsPercorridos.text.toString().toDouble()

        var qtd_unid_compr= qtdUnidades.text.toString().toDouble()
        var preco_unidade= precoUnidadeMedida.text.toString().toDouble()

        var autonomia= autonomiaDoVeiculo.text.toString().toDouble()

        var resultado=0.0
        if(autonomia !=0.0){

            resultado = (preco_unidade*trajeto/autonomia) +qtd_unid_compr*preco_unidade

            var formatado= "%.2f".format(resultado)
            var valorString= "R$ ${formatado}"
            custoDeRecursosConsumidos.setText(valorString)
        }else {
            Toast.makeText(this,"Automia deve ser maior que zero",Toast.LENGTH_LONG).show()
        }

        return resultado
    }

    private fun calculeCustoDeTempoAplicado():Double{
        var dias=diasDeTrabalho.text.toString().toDouble()
        var horas=horasDeTrabalho.text.toString().toDouble()
        var precoHora=precoDaHora.text.toString().toDouble()

        var resultado= (dias*horas*precoHora)
        custoDoTempoAplicado.setText(resultado.toString())
        return resultado
    }

    private fun salvar() {

        val invest = Investimento()

        invest.setNome(nome.text.toString())



        if (custoDeRecursosConsumidos.text.toString() != "") {
            invest.setPrecoDeCompra(custoDeRecursosConsumidos.text.toString().toDouble())
        }
        if (precoPretendido.text.toString() != "")
            invest.setPrecoDeVenda(precoPretendido.text.toString().toDouble())

        if (pontos.text.toString() != "")
            invest.setPontos(pontos.text.toString().toDouble())
        if (milhas.text.toString() != "")
            invest.setMilhas(milhas.text.toString().toDouble())
        if (diasDeTrabalho.text.toString()!="")
            invest.setDiasDeTrabalho(diasDeTrabalho.text.toString().toDouble())
        if (horasDeTrabalho.text.toString() != "")
            invest.setHorasDeTrabalho(horasDeTrabalho.text.toString().toDouble())

        if (precoDaHora.text.toString() != "")
            invest.setPrecoDaHora(precoDaHora.text.toString().toDouble())


        invest.calculaTotais()
        acumulado.setText(invest.getAcumulado().toString())
        liquido.setText(invest.getLiquido().toString())
        totalDeKMsPercorridos.setText(invest.getDistanciaPercorrida().toString())

        invest.printInvestimento()
    }

}