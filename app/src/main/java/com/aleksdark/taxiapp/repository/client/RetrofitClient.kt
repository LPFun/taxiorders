package com.aleksdark.taxiapp.repository.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private val BASE_URL: String = "http://www.roxiemobile.ru/careers/test/"

        private var retrofit: Retrofit? = null

        fun getClient(baseUrl : String? = null) : Retrofit?{
            if(retrofit == null){
                initRetrofitClient(baseUrl)
            }
            return retrofit
        }

        fun initRetrofitClient(baseUrl : String? = null){
            val okhttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()

            retrofit = Retrofit.Builder()
                .baseUrl(if (baseUrl == null) BASE_URL else baseUrl)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

    }
}