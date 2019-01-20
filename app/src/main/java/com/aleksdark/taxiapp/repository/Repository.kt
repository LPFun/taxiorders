package com.aleksdark.taxiapp.repository

import com.aleksdark.taxiapp.repository.client.RetrofitClient
import com.aleksdark.taxiapp.repository.entities.ActiveOrdersResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class Repository {
    fun getOrdersList(): PublishSubject<ActiveOrdersResponse>{
        val apiService = RetrofitClient.getClient()?.create(ApiService::class.java)
        val response = PublishSubject.create<ActiveOrdersResponse>()
        apiService!!.getActiveOrders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                response.onNext(ActiveOrdersResponse(it, null))
            }, {
                response.onNext(ActiveOrdersResponse(null, it))
            })
        return response
    }
}