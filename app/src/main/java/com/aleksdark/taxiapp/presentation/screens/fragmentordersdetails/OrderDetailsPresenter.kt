package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BasePresenter
import com.aleksdark.taxiapp.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class OrderDetailsPresenter : BasePresenter<Contract.View>(), Contract.Presenter {

    val repository = Repository()
    var disposable: Disposable? = null

    override fun onViewIsReady(orderModel: OrderModel) {
        when (orderModel.imgId) {
            null -> {
                //TODO: set placeholder to img
            }
            else -> {
                disposable = repository.getOrderBitmap(orderModel.imgId!!)
                    .subscribe({
                        if (it.error!!.length > 0) {
                            v?.showDetails(orderModel, it)
                        }
                    }, {
                        it.toString()
                    })
            }
        }
    }

    override fun viewIsReady() {

    }

    override fun onBackPressed() {
    }
}