package com.aleksdark.taxiapp.presentation.mvp

abstract class BasePresenter<V : MvpView>: MvpPresenter {

    var v : V? = null
    private set

    override fun attachView(view: Any) {
        v = view as V
    }

    override fun getView() : V? {
        return v
    }

    override fun detachView() {
        v = null
    }

    override fun destroy() {

    }
}