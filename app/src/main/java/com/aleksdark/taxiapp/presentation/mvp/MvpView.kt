package com.aleksdark.taxiapp.presentation.mvp

interface MvpView {
    fun showError(isShowing : Boolean)
    fun showLoading(isShowing : Boolean)
}