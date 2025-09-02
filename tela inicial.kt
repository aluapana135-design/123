package com.seubanco.app // Substitua pelo seu package real

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    private lateinit var tvWelcomeUser: TextView
    private lateinit var tvBalance: TextView
    private lateinit var tvCardName: TextView
    private lateinit var tvCpfCensored: TextView
    private lateinit var ivCardImage: ImageView // Para mostrar um ícone representativo do cartão

    private lateinit var btnPix: Button
    private lateinit var btnBoleto: Button
    private lateinit var btnConnectMachine: Button
    private lateinit var btnOtherFunctions: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Certifique-se que o nome do layout está correto

        // Inicializa os elementos da UI
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser)
        tvBalance = findViewById(R.id.tvBalance)
        tvCardName = findViewById(R.id.tvCardName)
        tvCpfCensored = findViewById(R.id.tvCpfCensored)
        ivCardImage = findViewById(R.id.ivCardImage)

        btnPix = findViewById(R.id.btnPix)
        btnBoleto = findViewById(R.id.btnBoleto)
        btnConnectMachine = findViewById(R.id.btnConnectMachine)
        btnOtherFunctions = findViewById(R.id.btnOtherFunctions)

        // Carregar dados do usuário (isso viria de uma API ou banco de dados real)
        loadUserData()

        // Configurar os listeners dos botões
        setupButtonListeners()
    }

    private fun loadUserData() {
        // Simulação de carregamento de dados do usuário
        val userName = "Maria Silva" // Dados reais viriam do login
        val userBalance = 2500.75 // Exemplo de saldo
        val cardHolderName = "MARIA SILVA"
        val userCpf = "12345678900" // CPF completo (apenas para simulação interna)

        tvWelcomeUser.text = "Olá, $userName!"
        tvBalance.text = "R$ %.2f".format(userBalance) // Formata o saldo para 2 casas decimais

        tvCardName.text = "Nome no Cartão: $cardHolderName"
        tvCpfCensored.text = "CPF: ${censorCpf(userCpf)}" // Aplica a censura

        // A imagem do cartão pode ser um ícone ou um logo do banco
        // ivCardImage.setImageResource(R.drawable.ic_visa_logo) // Exemplo se tiver um logo Visa
    }

    // Função para censurar o CPF
    private fun censorCpf(cpf: String): String {
        return if (cpf.length == 11) {
            "***.${cpf.substring(3, 6)}.***-${cpf.substring(9, 11)}"
            // Ou uma censura mais simples: "XXX.XXX.XXX-XX"
        } else {
            "CPF Inválido"
        }
    }

    private fun setupButtonListeners() {
        btnPix.setOnClickListener {
            Toast.makeText(this, "Abrir tela de Pix", Toast.LENGTH_SHORT).show()
            // Iniciar nova Activity para Pix
            // val intent = Intent(this, PixActivity::class.java)
            // startActivity(intent)
        }

        btnBoleto.setOnClickListener {
            Toast.makeText(this, "Abrir tela de Pagar Boleto", Toast.LENGTH_SHORT).show()
            // Iniciar nova Activity para Pagar Boleto
        }

        btnConnectMachine.setOnClickListener {
            Toast.makeText(this, "Abrir tela de Conectar Maquininha", Toast.LENGTH_SHORT).show()
            // Iniciar nova Activity para Conectar Maquininha
        }

        btnOtherFunctions.setOnClickListener {
            Toast.makeText(this, "Abrir tela de Mais Opções", Toast.LENGTH_SHORT).show()
            // Iniciar nova Activity para Mais Opções
        }
    }
}