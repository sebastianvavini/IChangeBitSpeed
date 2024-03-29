package com.araujosoftware.ichangebitspeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.araujosoftware.ichangebitspeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding


    private lateinit var nome: EditText
    private lateinit var acumulado: EditText
    private lateinit var liquido: EditText
    private lateinit var custoDoTempoAplicado: TextView
    private var custoDoTempoAplicadoDouble = 0.00


    private lateinit var custoDeRecursosConsumidos: TextView
    private lateinit var valorDoAporte: TextView
    private lateinit var precoPretendido: EditText

    //private lateinit var lucro: EditText abandona a ideia de lucro. Focar em equity. No capital acumulado
    private lateinit var pontos: EditText
    private lateinit var milhas: EditText
    private lateinit var horasDeTrabalho: EditText
    private lateinit var diasDeTrabalho: EditText
    private lateinit var precoDaHora: EditText
    private lateinit var precoLitroDeCombustivel: EditText
    private  lateinit var precoUnidadeDeMedida:EditText

    private lateinit var totalDeKMsPercorridos: EditText
    private lateinit var vezesPercorridas: EditText

    private lateinit var localDeOrigemDoMotorista: EditText
    private lateinit var localDeEmbarqueDoPassageiro: EditText
    private lateinit var localDeDesembarqueDoPassageiro: EditText


    private lateinit var autonomiaDoVeiculo: EditText //autonomia

    private lateinit var qtdUnidades: EditText
    private lateinit var botaoCalcularGanhos: Button
    private lateinit var brutoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        fazerBinding()

        setContentView(binding.root)
        addOnClickListeners()


    }

    private fun fazerBinding() {
        nome = binding.editTextNome
        acumulado = binding.editTextBruto
        liquido = binding.editTextLiquido
        custoDoTempoAplicado = binding.textViewCustoDoTempoAplicado

        custoDeRecursosConsumidos = binding.textviewCustoDeRecursosConsumidos
        precoPretendido = binding.editTextPrecoPretendido
        precoLitroDeCombustivel = binding.editTextPrecoPorLitroCombustivel
        precoUnidadeDeMedida=binding.editTextPrecoPorUnidade
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
        botaoCalcularGanhos = binding.buttonCalcularGanhos
        brutoEditText = binding.editTextBruto


    }

    private fun addOnClickListeners() {
        binding.imageSave.setOnClickListener(this)
        custoDoTempoAplicado.setOnClickListener(this)
        binding.radioSimDeslocamento.setOnClickListener(this)
        binding.radioNaoDeslocamento.setOnClickListener(this)

        binding.textviewCustoDeRecursosConsumidos.setOnClickListener(this)
        valorDoAporte.setOnClickListener(this)
        botaoCalcularGanhos.setOnClickListener(this)
        binding.radioNaoEraVeiculoProprio.setOnClickListener(this)
        binding.radioSimVeiculoProprio.setOnClickListener(this)

    }
    private fun naoHouveDeslocamento(){
        println(" Some Perguntas desnecessarias")
        binding.linearLayoutTrajeto.isVisible = false
        binding.linearlayoutFoiEmVeiculoProprio.isVisible = false
        binding.textviewAutonomia.isVisible = false
        binding.linearLayoutAutonomia.isVisible = false
        binding.editTextKmsPercorridos.setText("0")
    }
    private fun houveDeslocamento(){
        binding.linearLayoutTrajeto.isVisible = true
        binding.linearlayoutFoiEmVeiculoProprio.isVisible = true
        binding.textviewAutonomia.isVisible = true
        binding.linearLayoutAutonomia.isVisible = true
    }

    override fun onClick(p: View) {
        if (p.id == R.id.image_save) {
            println("Ouvindo...")
            salvar()
        }
        if (p.id == R.id.textView_custo_do_tempo_aplicado) {
            calculeCustoDeTempoAplicado()
        }
        if (p.id == R.id.radio_sim_deslocamento) {
            houveDeslocamento()
        }
        if (p.id == R.id.radio_nao_deslocamento) {
            naoHouveDeslocamento()
        }
        if (p.id == R.id.radio_nao_era_veiculo_proprio) {
            binding.linearLayoutAutonomia.isVisible = false
        }
        if (p.id == R.id.radio_sim_veiculo_proprio) {
            binding.linearLayoutAutonomia.isVisible = true
        }


        if (p.id == R.id.textview_custo_de_recursos_consumidos) {
            calculeCustoDeRecursosConsumidos()
        }
        if (p.id == R.id.textview_valor_do_aporte) {

            calculeValorDoAporte()
        }
        if (p.id == R.id.button_calcular_ganhos) {
            calcularGanhos()
        }
    }


    private fun calculeCustoDeTempoAplicado(): Double {

        var dias = 0.00
        var horas = 0.00
        var precoHora = 0.00
        var resultado = (dias * horas * precoHora)


        if (diasDeTrabalho.text.toString() != "" &&
            horasDeTrabalho.text.toString() != "" &&
            diasDeTrabalho.text.toString() != ""
        ) {

            dias = diasDeTrabalho.text.toString().toDouble()
            horas = horasDeTrabalho.text.toString().toDouble()
            precoHora = precoDaHora.text.toString().toDouble()
            resultado = (dias * horas * precoHora)

        }

        var formatado = "%.2f".format(resultado)
        custoDoTempoAplicado.setText(formatado)
        return resultado
    }
    private fun calculeCustoDeRecursosConsumidos(): Double {


        var trajeto = 0.00
        var preco_litro = 0.01
        var autonomia = 0.01

        var qtd_unid_compr = 0.0
        var preco_unidade_adicional_compr = 0.01


        var resultado = 0.00

        if (totalDeKMsPercorridos.text.toString() != "" &&
            qtdUnidades.text.toString() != "" &&
            precoLitroDeCombustivel.text.toString() != "" &&
            autonomiaDoVeiculo.text.toString() != ""&&precoUnidadeDeMedida.text.toString()!=""
        ) {

            trajeto = totalDeKMsPercorridos.text.toString().toDouble()
            autonomia = autonomiaDoVeiculo.text.toString().toDouble()

            qtd_unid_compr = qtdUnidades.text.toString().toDouble()
            preco_litro = precoLitroDeCombustivel.text.toString().toDouble()
            preco_unidade_adicional_compr=precoUnidadeDeMedida.text.toString().toDouble()



            if (autonomia == 0.0) {
                Toast.makeText(this, "Automia deve ser maior que zero", Toast.LENGTH_LONG).show()
            }
            if (autonomia != 0.01 && trajeto != 0.0) {

                println("##### atenção aqui  if (autonomia != 0.01 && trajeto != 0.0)")

                println(trajeto)
                println(preco_litro)
                println(autonomia)
                println(qtd_unid_compr)
                println(preco_unidade_adicional_compr)



                trajeto = totalDeKMsPercorridos.text.toString().toDouble()
                qtd_unid_compr = qtdUnidades.text.toString().toDouble()
                preco_litro = precoLitroDeCombustivel.text.toString().toDouble()
                preco_unidade_adicional_compr=precoUnidadeDeMedida.text.toString().toDouble()

                autonomia = autonomiaDoVeiculo.text.toString().toDouble()



                resultado =   (preco_litro * trajeto / autonomia) + qtd_unid_compr * preco_unidade_adicional_compr
                // removido devido o fato do que é comprado é convertido em combustivel e não é consumo


                println("########  Resultado igual a: ${resultado}")

                var formatado = "%.2f".format(resultado)
                var valorString = "${formatado}"
                custoDeRecursosConsumidos.setText(valorString)

            }

            if (autonomia == 0.01 && trajeto == 0.0) {
                if (qtdUnidades.text.toString() != "" && precoLitroDeCombustivel.text.toString() != "") {

                    qtd_unid_compr = qtdUnidades.text.toString().toDouble()
                    preco_unidade_adicional_compr = precoUnidadeDeMedida.text.toString().toDouble()
                }

                println(" if(autonomia ==0.01 && trajeto==0.0){")
                println("preço da unidade ${preco_unidade_adicional_compr}")
                println(" qtd: ${qtd_unid_compr}")


                resultado = qtd_unid_compr * preco_unidade_adicional_compr
                println("########  Resultado igual a: ${resultado}")

                var formatado = "%.2f".format(resultado)
                var valorString = "R$ ${formatado}"
                custoDeRecursosConsumidos.setText(valorString)
            }


        } else {
            Toast.makeText(this, "Todos os valores devem ser preenchidos", Toast.LENGTH_LONG)
        }


        return resultado
    }
    private fun calculeValorDoAporte() {

        println("VALOR DO APORTE CALCULANDO...")
        var horasTrab = calculeCustoDeTempoAplicado()
        var consumo = calculeCustoDeRecursosConsumidos()

        var resultado = horasTrab + consumo
        var formatadoStr = "%.2f".format(resultado)


        valorDoAporte.setText(formatadoStr)
    }
    private fun calcularGanhos() {

        var ganhoBruto = 0.0
        var ganhoLiquido = 0.0



        if (binding.editTextPrecoRealizado.text.toString() != "" && valorDoAporte.text.toString() != "") {
            ganhoBruto = binding.editTextPrecoRealizado.text.toString().toDouble()


            var custos = custoDeRecursosConsumidos.text.toString().toDouble()

            if (custoDeRecursosConsumidos.text.toString() != "") {
                ganhoLiquido = ganhoBruto - custos
                println(" O ganho liquido é de:  ${ganhoLiquido}")
            }


            var formatado = "%.2f".format(ganhoLiquido)
            brutoEditText.setText(ganhoBruto.toString())
            liquido.setText(formatado)
        }
    }

    private fun salvar() {

        val invest = Investimento()
        val eu= Eu()

        invest.setNome(nome.text.toString())

      //  eu.adicionarInvestimento()
        eu.somarInvestimentos()



        if (custoDeRecursosConsumidos.text.toString() != "") {
            invest.setPrecoDeCompra(custoDeRecursosConsumidos.text.toString().toDouble())

        }
        if (precoPretendido.text.toString() != "")
            invest.setPrecoDeVenda(precoPretendido.text.toString().toDouble())

        if (pontos.text.toString() != "")
            invest.setPontos(pontos.text.toString().toDouble())
        if (milhas.text.toString() != "")
            invest.setMilhas(milhas.text.toString().toDouble())
        if (diasDeTrabalho.text.toString() != "")
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