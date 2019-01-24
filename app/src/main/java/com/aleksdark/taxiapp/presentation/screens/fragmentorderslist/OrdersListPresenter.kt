package com.aleksdark.taxiapp.presentation.screens.fragmentorderslist

import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BasePresenter
import com.aleksdark.taxiapp.presentation.utils.Mapper
import com.aleksdark.taxiapp.repository.Repository
import io.reactivex.disposables.Disposable

class OrdersListPresenter: BasePresenter<Contract.View>(), Contract.Presenter {
    override fun onOrderClick(order: OrderModel) {
        v?.goToFragment(order)
    }

    private var disposable: Disposable? = null
    private val repository = Repository()


    override fun viewIsReady() {
        v?.showLoading(true)
        getData()
    }

    private fun getData(){
        disposable = repository.getOrdersList().subscribe({
            v?.showLoading(false)
            if (it.error == null){
                v?.showOrdersList(Mapper.mapResponse(it.ordersList!!))
            } else{
                v?.showError(true)
            }
        })
    }

    override fun destroy() {
        if (disposable == null && !disposable!!.isDisposed){
            disposable!!.dispose()
        }
    }
}