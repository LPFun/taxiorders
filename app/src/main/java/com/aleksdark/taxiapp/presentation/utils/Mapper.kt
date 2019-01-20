package com.aleksdark.taxiapp.presentation.utils

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.repository.entities.ActiveOrder
import com.aleksdark.taxiapp.repository.entities.ActiveOrdersResponse

class Mapper{
    companion object {
        fun mapResponse(response: List<ActiveOrder>) : List<OrderModel>{
            val mappedList = ArrayList<OrderModel>()
            response.forEach{
                val orderModel = OrderModel()
                orderModel.id = it.id
                orderModel.startAddress = "Из: ${it.startAddress!!.city} ${it.startAddress!!.address}"
                orderModel.endAddress = "В: ${it.endAddress!!.city} ${it.endAddress!!.address}"
                orderModel.date = it.orderTime
                orderModel.cost = "${(it.price!!.amount)!!.div(100)} ${it.price!!.currency}"
                mappedList.add(orderModel)
            }

            return mappedList
        }
    }
}