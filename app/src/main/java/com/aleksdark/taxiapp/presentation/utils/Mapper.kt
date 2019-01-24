package com.aleksdark.taxiapp.presentation.utils

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.repository.entities.ActiveOrder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Mapper{
    companion object {
        fun mapResponse(response: List<ActiveOrder>) : List<OrderModel>{
            val mappedList = ArrayList<OrderModel>()
            response.forEach{
                val orderModel = OrderModel()
                orderModel.id = it.id
                orderModel.startAddress = "Из: ${it.startAddress!!.city} ${it.startAddress!!.address}"
                orderModel.endAddress = "В: ${it.endAddress!!.city} ${it.endAddress!!.address}"
                orderModel.date = getDate(it.orderTime)
                orderModel.time = getTime(it.orderTime)
                orderModel.cost = "${(it.price!!.amount)!!.div(100).toFloat()} ${getCurrencySymbol(it.price!!.currency)}"
                mappedList.add(orderModel)
            }
            return mappedList
        }

        private fun getCurrencySymbol(currencyString: String?): String{
            val currency = Currency.getInstance(currencyString)
            return currency.symbol
        }

        private fun getTime(jsonTimeStr: String?): String{
            val dateFormat = DateFormat.getTimeInstance()
            return dateFormat.format(parseDateTime(jsonTimeStr))
        }

        private fun getDate(jsonDateStr : String?): String {
            val dateFormat = DateFormat.getDateInstance()
            return dateFormat.format(parseDateTime(jsonDateStr))
        }

        private fun parseDateTime(jsonDateTimeStr : String?) : Date{
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale("ru"))
            simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            return simpleDateFormat.parse(jsonDateTimeStr)
        }
    }
}