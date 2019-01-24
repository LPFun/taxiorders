package com.aleksdark.taxiapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.models.OrderModel

class OrdersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var ordersList: List<OrderModel> = ArrayList()
    var onItemClick: (item: OrderModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        val holder = OrderViewHolder(view)

        view.setOnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION)
                onItemClick(ordersList.get(holder.adapterPosition))
        }
        return holder
    }

    override fun getItemCount(): Int {
        return ordersList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OrderViewHolder).bind(ordersList.get(position))
    }
}