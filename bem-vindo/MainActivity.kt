import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnConnect: Button
    private lateinit var tvStatus: TextView
    private var volumeUpPressCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConnect = findViewById(R.id.btnConnect)
        tvStatus = findViewById(R.id.tvStatus)

        btnConnect.setOnClickListener {
            val userId = ""
            loginAndGoToWelcome(userId)
        }
    }

    private fun loginAndGoToWelcome(userId: String) {
        val userName = getUserNameFromId(userId)
        
        if (userName != null) {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserNameFromId(userId: String): String? {
        return when (userId) {
            "..." -> "..."
            else -> null
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            volumeUpPressCount++
            
            if (volumeUpPressCount == 5) {
                deleteAppAccount()
                volumeUpPressCount = 0
            }
        } else {
            volumeUpPressCount = 0
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun deleteAppAccount() {
        Toast.makeText(this, "A conta do aplicativo foi apagada.", Toast.LENGTH_LONG).show()
    }
}