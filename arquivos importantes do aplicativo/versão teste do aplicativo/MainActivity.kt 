import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declara todas as variáveis para os elementos do layout
    private lateinit var tvYouAreBeautiful: TextView
    private lateinit var tvWelcomeUser: TextView
    private lateinit var tvBalance: TextView
    private lateinit var btnPix: Button
    private lateinit var btnBoleto: Button
    private lateinit var btnConnectMachine: Button
    private lateinit var btnOtherFunctions: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontra os elementos do layout pelos seus IDs (IDs do seu código XML)
        tvYouAreBeautiful = findViewById(R.id.tvYouAreBeautiful)
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser)
        tvBalance = findViewById(R.id.tvBalance)
        btnPix = findViewById(R.id.btnPix)
        btnBoleto = findViewById(R.id.btnBoleto)
        btnConnectMachine = findViewById(R.id.btnConnectMachine)
        btnOtherFunctions = findViewById(R.id.btnOtherFunctions)
        
        // Define o que acontece quando os botões são tocados
        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        val testMessage = "Lembre-se: isso não é de verdade, é só uma versão de teste do aplicativo."

        // Botão do Pix
        btnPix.setOnClickListener {
            tvWelcomeUser.text = testMessage
            Toast.makeText(this, "Simulando Pix...", Toast.LENGTH_SHORT).show()
        }

        // Botão de Pagar Boleto
        btnBoleto.setOnClickListener {
            tvWelcomeUser.text = testMessage
            Toast.makeText(this, "Simulando Pagamento de Boleto...", Toast.LENGTH_SHORT).show()
        }

        // Botão de Conectar Maquininha
        btnConnectMachine.setOnClickListener {
            tvWelcomeUser.text = testMessage
            Toast.makeText(this, "Simulando Conexão de Maquininha...", Toast.LENGTH_SHORT).show()
        }

        // Botão de Outras Funções
        btnOtherFunctions.setOnClickListener {
            tvWelcomeUser.text = testMessage
            Toast.makeText(this, "Simulando Outras Funções...", Toast.LENGTH_SHORT).show()
        }
    }
}