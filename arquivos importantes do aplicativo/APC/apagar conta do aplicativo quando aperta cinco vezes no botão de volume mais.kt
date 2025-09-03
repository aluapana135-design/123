import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Conta quantas vezes o botão de volume "mais" foi pressionado.
    private var volumeUpPressCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Verifica se a tecla pressionada é o botão de volume 'para cima'.
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            volumeUpPressCount++
            Toast.makeText(this, "Contagem: $volumeUpPressCount/5", Toast.LENGTH_SHORT).show()

            // Checa se o botão foi pressionado 5 vezes.
            if (volumeUpPressCount == 5) {
                deleteAppAccount()
                // Reseta a contagem para 0.
                volumeUpPressCount = 0
            }
        } else {
            // Se outra tecla for pressionada, a contagem é reiniciada.
            volumeUpPressCount = 0
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun deleteAppAccount() {
        // Esta função apaga a conta do aplicativo.
        // Aqui, você colocaria o código para:
        // 1. Limpar dados de login salvos no aparelho.
        // 2. Apagar o banco de dados local do usuário.
        // 3. Notificar o servidor para apagar a conta, se necessário.

        // Simulação da ação:
        Toast.makeText(this, "A conta do aplicativo foi apagada.", Toast.LENGTH_LONG).show()

        // Em um aplicativo real, você faria algo como:
        // SharedPreferences.Editor().clear().commit()
        // appDatabase.userDao().deleteAllUsers()
    }
}