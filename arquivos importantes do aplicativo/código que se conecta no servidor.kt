import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var btnConnect: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConnect = findViewById(R.id.btnConnect)
        tvStatus = findViewById(R.id.tvStatus)

        btnConnect.setOnClickListener {
            connectToServer()
        }
    }

    private fun connectToServer() {
        val client = OkHttpClient()

        // IMPORTANTE: Substitua 'SEU_IP_AQUI' pelo IP do seu computador na rede local.
        // Você pode encontrar seu IP usando 'ipconfig' no Windows ou 'ifconfig' no Linux/macOS.
        val url = "http://SEU_IP_AQUI:5000/dados"
        val request = Request.Builder().url(url).build()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && responseBody != null) {
                        val json = JSONObject(responseBody)
                        val message = json.getString("mensagem")
                        tvStatus.text = "Status: Conectado com sucesso!\nMensagem do servidor: $message"
                    } else {
                        tvStatus.text = "Falha na conexão: ${response.code}"
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    tvStatus.text = "Erro: ${e.message}"
                }
            }
        }
    }
}