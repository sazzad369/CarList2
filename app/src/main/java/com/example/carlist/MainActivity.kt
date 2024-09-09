package com.example.carlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carlist.adaptor.adptor
import com.example.carlist.databinding.ActivityMainBinding
import com.example.carlist.databinding.AddCarModelBinding
import com.example.carlist.model.Cars
import java.time.Year

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carAdapter: adptor
    val Car = ArrayList<Cars>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.carRv.layoutManager = LinearLayoutManager(this)


        Car.add(
            Cars(
                "1998 BMW 5 Series (E39)",
                1998,
                4000.00,
                "Full-size luxury sedan with a more modern design and advanced technology.",
                R.drawable.img
            )
        )
        Car.add(
            Cars(
                "1999 BMW X5 (E53)",
                1999,
                5000.00,
                "One of the first luxury SUVs from BMW, blending performance with practicality.",
                R.drawable.img_2
            )
        )
        Car.add(
            Cars(
                "2001 BMW 3 Series (E46)",
                2001,
                4000.00,
                "Highly regarded for its driving dynamics and stylish design.",
                R.drawable.img_3
            )
        )
        Car.add(
            Cars(
                "2003 BMW 5 Series (E60)",
                2003,
                5000.00,
                "Midsize luxury sedan featuring innovative technology and a more aggressive look.",
                R.drawable.img_3
            )
        )
        Car.add(
            Cars(
                "2004 BMW 7 Series (E65)",
                2004,
                6000.00,
                "Full-size luxury sedan known for its advanced electronics and luxurious interior.",
                R.drawable.img_4
            )
        )
        Car.add(
            Cars(
                "2006 BMW M3 (E46)",
                2006,
                15000.00,
                "High-performance sports coupe with a high-revving inline-six engine.",
                R.drawable.img_5
            )
        )
        Car.add(
            Cars(
                "2007 BMW X6 (E71)",
                2007,
                8000.00,
                "Sporty luxury SUV that combines elements of a coupe with off-road capability.",
                R.drawable.img_6
            )
        )
        Car.add(
            Cars(
                "2008 BMW 1 Series (E82)",
                2008,
                5000.00,
                "Compact coupe with a sporty feel and engaging driving experience.",
                R.drawable.img_7
            )
        )
        Car.add(
            Cars(
                "2009 BMW 3 Series (E90)",
                2009,
                6000.00,
                "Sedan version of the popular compact series, known for its balance of comfort and performance.",
                R.drawable.img_8
            )
        )
        Car.add(
            Cars(
                "2010 BMW 5 Series (F10)",
                2010,
                10000.00,
                "New generation of the 5 Series, offering improved technology and refined driving dynamics.",
                R.drawable.img_9
            )
        )
        Car.add(
            Cars(
                "1990 BMW 3 Series (E30)",
                1990,
                180000.00,
                "Classic compact executive car, known for its sporty handling and iconic design.",
                R.drawable.img_10
            )
        )
        Car.add(
            Cars(
                "1991 BMW 5 Series (E34)",
                1991,
                190000.00,
                "Mid-sized luxury sedan offering a blend of comfort and performance with a timeless design.",
                R.drawable.img_11
            )
        )
        Car.add(
            Cars(
                "1992 BMW 7 Series (E32)",
                1992,
                200000.00,
                "Full-size luxury sedan with advanced features for its time and a smooth ride.",
                R.drawable.img_12
            )
        )
        Car.add(
            Cars(
                "1995 BMW Z3",
                1995,
                210000.00,
                "Full-size luxury sedan with advanced features for its time and a smooth ride.",
                R.drawable.img_13
            )
        )
        Car.add(
            Cars(
                "1990 BMW 3 Series (E30)",
                1990,
                5000.00,
                "Classic compact executive car, known for its sporty handling and iconic design.",
                R.drawable.img_12
            )
        )
        Car.add(
            Cars(
                "1991 BMW 5 Series (E34)",
                1991,
                3000.00,
                "Mid-sized luxury sedan offering a blend of comfort and performance with a timeless design.",
                R.drawable.img_2
            )
        )
        Car.add(
            Cars(
                "1992 BMW 7 Series (E32)",
                1992,
                4000.00,
                "Full-size luxury sedan with advanced features for its time and a smooth ride.",
                R.drawable.img_3
            )
        )
        Car.add(
            Cars(
                "1995 BMW Z3",
                1995,
                6000.00,
                "Roadster that marked BMW's entry into the affordable sports car segment.",
                R.drawable.img_4
            )
        )
        Car.add(
            Cars(
                "1997 BMW 3 Series (E36)",
                1997,
                3000.00,
                "Popular compact sports sedan known for its refined driving dynamics.",
                R.drawable.img_5
            )
        )

        carAdapter = adptor(Car)
        binding.carRv.adapter = carAdapter

        carAdapter.onClick = {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("Name", it.modelName)
            intent.putExtra("year", it.modelYear)
            intent.putExtra("Price", it.modelPrice)
            intent.putExtra("Descriptiom", it.modelDescription)
            intent.putExtra("Image", it.modelImg)
            startActivity(intent)

        }
        binding.floatingActionButton.setOnClickListener {
            showCarAddDialog()
        }

    }

    private fun showCarAddDialog() {
        val dialogview = AddCarModelBinding.inflate (layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("Add Cars")
            .setView(dialogview.root)
            .setPositiveButton("Add") { _, _ ->
                val name = dialogview.modelName.text.toString()
                val year = dialogview.EnterYear.text.toString()
                val price = dialogview.Enterprice.text.toString().toDouble()
                val description = dialogview.EnterDesc.text.toString()
                val image = R.drawable.img
                Car.add(Cars(name, year , price, description, image))
                carAdapter.notifyItemInserted(Car.size - 1)

            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}