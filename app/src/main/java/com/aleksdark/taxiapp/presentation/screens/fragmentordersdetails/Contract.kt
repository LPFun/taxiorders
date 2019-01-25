package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.MvpPresenter
import com.aleksdark.taxiapp.presentation.mvp.MvpView
import com.aleksdark.taxiapp.repository.entities.OrdersImgResponse

interface Contract{
    interface View: MvpView{
        fun showDetails(orderModel: OrderModel, ordersImgResponse: OrdersImgResponse)
    }
    interface Presenter: MvpPresenter{
        fun onViewIsReady(orderModel: OrderModel)
        fun onBackPressed()
    }
}