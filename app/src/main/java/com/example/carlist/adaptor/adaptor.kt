package com.example.carlist.adaptor

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carlist.databinding.CarModelListBinding
import com.example.carlist.model.Cars

class adptor (private val carList:ArrayList<Cars>): RecyclerView.Adapter<adptor.MyViewHolder>() {
    var onClick:((Cars) -> Unit)? = null

    class MyViewHolder(val binding: CarModelListBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = CarModelListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            nametv1.text = carList[position].modelName
            nametv2.text = "Year : "+ carList[position].modelYear.toString()
            nametv3.text = "Price :"+ carList[position].modelPrice.toString()
            nametv4.text = carList[position].modelDescription.toString()
            circleImg.setImageResource(carList[position].modelImg)

        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(carList[position])
        }
        holder.itemView.setOnClickListener{
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("detete car item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Yes") { _,_ ->
                    carList.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("No", null)
                .show()
            true
        }
    }

}