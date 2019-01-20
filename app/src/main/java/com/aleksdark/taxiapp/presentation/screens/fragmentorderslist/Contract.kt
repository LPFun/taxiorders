package com.aleksdark.taxiapp.presentation.screens.fragmentorderslist

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.MvpPresenter
import com.aleksdark.taxiapp.presentation.mvp.MvpView

interface Contract {
    interface View : MvpView{
        fun showOrdersList(dataList : List<OrderModel>)
    }
    interface Presenter : MvpPresenter{
        fun onOrderClick()
    }
}