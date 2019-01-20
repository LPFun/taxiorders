package com.aleksdark.taxiapp.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aleksdark.taxiapp.presentation.models.OrderModel
import kotlinx.android.synthetic.main.order_item.view.*

class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(orderItem: OrderModel) {
        with(itemView) {
            order_start_address_tv.text = orderItem.startAddress
            order_end_address_tv.text = orderItem.endAddress
            order_date_tv.text = orderItem.date
            order_cost_tv.text = orderItem.cost
        }
    }
}