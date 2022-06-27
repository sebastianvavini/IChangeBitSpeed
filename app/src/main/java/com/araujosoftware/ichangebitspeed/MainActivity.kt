package com.araujosoftware.ichangebitspeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.araujosoftware.ichangebitspeed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityMainBinding

    private lateinit var nome: EditText
    private lateinit var acumulado: EditText
    private lateinit var liquido: EditText
    private lateinit var precoCompra: EditText
    private lateinit var precoVenda: EditText
    private lateinit var lucro: EditText
    private lateinit var pontos: EditText
    private lateinit var milhas: EditText
    private lateinit var horasDeTrabalho: EditText
    private lateinit var diasDeTrabalho: EditText
    private lateinit var precoDaHora: EditText
    private lateinit var trajetoEmKMs: EditText
    private lateinit var kmPorLitro: EditText
    private lateinit var qtdLitros: EditText
    private lateinit var precoPorLitro: EditText
    private lateinit var qtdUnidades: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        nome = binding.editTextNome
        acumulado = binding.editTextAcumulado
        liquido = binding.editTextLiquido
        precoCompra = binding.editTextPrecoDeCompra
        precoVenda = binding.editTextPrecoDeVenda
        lucro = binding.editTextLucro
        pontos = binding.editTextPontos
        milhas = binding.editTextMilhas
        horasDeTrabalho = binding.editTextHorasDeTrabalho
        diasDeTrabalho = binding.editTextDiasDeTrabalho
        precoDaHora = binding.editTextPrecoHora
        trajetoEmKMs = binding.editTextTrajetoKms
        kmPorLitro = binding.editTextKmForLiter
        qtdLitros = binding.editTextLitrosComprados
        precoPorLitro = binding.editTextPrecoPorLitro
        qtdUnidades = binding.editTextQtdUnidades
        binding.imageSave.setOnClickListener(this)

        setContentView(binding.root)


    }

    override fun onClick(p: View) {
        if (p.id == R.id.image_save) {
            println("Ouvindo...")
            salvar()
        }
    }

    private fun salvar() {

        val invest = Investimento()

        invest.setNome(nome.text.toString())


        if (precoCompra.text.toString() != "") {
            invest.setPrecoDeCompra(precoCompra.text.toString().toDouble())
        }
        if (precoVenda.text.toString() != "")
            invest.setPrecoDeVenda(precoVenda.text.toString().toDouble())
        if (lucro.text.toString() != "")
            invest.setLucro(lucro.text.toString().toDouble())
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


        invest.printInvestimento()
    }

}