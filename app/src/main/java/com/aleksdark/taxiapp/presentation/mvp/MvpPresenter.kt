package com.aleksdark.taxiapp.presentation.mvp

interface MvpPresenter {
    fun attachView(view : Any)
    fun detachView()
    fun getView() : MvpView?
    fun viewIsReady()
    fun destroy()
}