package navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import navigationcomponentturtorialcom.example.datapassactivitytoactivityapp.databinding.ActivityBsecondBinding

class BSecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBsecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBsecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvRollNo = binding.tvRollNo
        val tvName = binding.tvName
        val tvAge = binding.tvAge
        val tvSalary = binding.tvSalary
        val tvGender = binding.tvGender

        // lấy bundle kiểu đối tượng được gửi 
        val bundle = intent.getBundleExtra("user")
        tvRollNo.text = bundle?.getLong("rollNo").toString()
        tvName.text = bundle?.getString("name").toString()
        tvAge.text = bundle?.getInt("age").toString()
        tvSalary.text = bundle?.getDouble("salary").toString()

        tvGender.text = if (bundle!!.getBoolean("gender", true)) "Male" else "Female"
    }
}