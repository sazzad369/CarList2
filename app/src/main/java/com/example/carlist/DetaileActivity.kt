package com.example.carlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carlist.databinding.ActivityDetaileBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetaileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetaileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val Year = intent.getIntExtra("year", 0)
        val price = intent.getDoubleExtra("Price", 0.0)
        val Description = intent.getStringExtra("Description")
        val image = intent.getIntExtra("Image", 0)

        binding.apply {
            carNametv.text = name
            yeartv2.text = Year.toString()
            pricetv3.text = price.toString()
            carDesc5.text = Description
            carimg.setImageResource(image)
        }
    }
}