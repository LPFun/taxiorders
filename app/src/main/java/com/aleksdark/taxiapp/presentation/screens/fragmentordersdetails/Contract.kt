package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import com.aleksdark.taxiapp.presentation.mvp.MvpPresenter
import com.aleksdark.taxiapp.presentation.mvp.MvpView

interface Contract{
    interface View: MvpView{
        fun showDetails()
    }
    interface Presenter: MvpPresenter{
        fun onViewIsReady()
        fun onBackPressed()
    }
}