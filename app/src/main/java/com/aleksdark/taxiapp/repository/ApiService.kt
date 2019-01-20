package com.aleksdark.taxiapp.repository

import com.aleksdark.taxiapp.repository.entities.ActiveOrder
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("orders.json")
    fun getActiveOrders() :  Single<List<ActiveOrder>>
}