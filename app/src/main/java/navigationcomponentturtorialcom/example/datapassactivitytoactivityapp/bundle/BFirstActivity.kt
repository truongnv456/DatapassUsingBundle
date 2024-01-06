package navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.bundle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.R
import navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.databinding.ActivityBfirstBinding

class BFirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBfirstBinding
    var genderState = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBfirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etRollNo = binding.etRollNo
        val etName = binding.etName
        val etAge = binding.etAge
        val etSalary = binding.etSalary
        val rgGender = binding.rgGender


        rgGender.setOnCheckedChangeListener { _, id ->
            if (id == R.id.radioMale) {
                genderState = true
            } else if (id == R.id.radioFemale) {
                genderState = false
            }
        }

        binding.btnSendData.setOnClickListener {
            if (etRollNo.text.toString().isEmpty()) {
                etRollNo.error = "required"
            } else if (etName.text.toString().isEmpty()) {
                etName.error = "required"
            } else if (etAge.text.toString().isEmpty()) {
                etAge.error = "required"
            } else if (etSalary.text.toString().isEmpty()) {
                etSalary.error = "required"
            } else {
                // Create an intent
                val sendDataIntent = Intent(this, BSecondActivity::class.java)

                // truyền object sử dụng Bundle với scope function
                val bundle = Bundle().apply {
                    putLong("rollNo", etRollNo.text.toString().toLong())
                    putString("name", etName.text.toString())
                    putInt("age", etAge.text.toString().toInt())
                    putDouble("salary", etSalary.text.toString().toDouble())
                    putBoolean("gender", genderState)
                }
                sendDataIntent.putExtra("user", bundle)

                startActivity(sendDataIntent)
            }
        }
    }
}