package com.aleksdark.taxiapp.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.aleksdark.taxiapp.repository.client.RetrofitClient
import com.aleksdark.taxiapp.repository.entities.ActiveOrdersResponse
import com.aleksdark.taxiapp.repository.entities.OrdersImgResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.io.IOException
import java.net.URL
import java.util.concurrent.Callable


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

    fun getOrderBitmap(imgId: String) : PublishSubject<OrdersImgResponse> {
        val response = PublishSubject.create<OrdersImgResponse>()
        Observable.fromCallable(CallableGetImg(imgId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                response.onNext(OrdersImgResponse(it, null))
            }, {
                response.onNext(OrdersImgResponse(null, it.toString()))
            })
        return response
    }
}

class CallableGetImg(val imgId: String) : Callable<Bitmap>{
    fun getImg(): Bitmap? {
        var image: Bitmap? = null
        try {
            val url = URL("http://www.roxiemobile.ru/careers/test/images/$imgId")
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        } catch (e: IOException) {
            System.out.println(e)
        }

        return image
    }

    override fun call(): Bitmap? {
        return getImg()
    }
}