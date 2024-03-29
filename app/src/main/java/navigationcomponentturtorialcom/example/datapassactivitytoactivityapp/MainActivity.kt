package navigationcomponentturtorialcom.example.datapassactivitytoactivityapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.bundle.BFirstActivity
import navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUsingBundle.setOnClickListener {
            startActivity(Intent(this, BFirstActivity::class.java))
        }
    }
}