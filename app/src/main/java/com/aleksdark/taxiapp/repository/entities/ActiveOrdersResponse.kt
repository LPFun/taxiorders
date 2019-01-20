package com.aleksdark.taxiapp.repository.entities

data class ActiveOrdersResponse(var ordersList: List<ActiveOrder>? = null, var error: Throwable? = null)
