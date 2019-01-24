package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.mvp.BaseView

class OrderDetailsView : BaseView<Contract.Presenter>(), Contract.View {
    override fun getLayoutId(): Int {
        return R.layout.fragment_orders_detail
    }

    override fun getPresenter(): Contract.Presenter {
        return OrderDetailsPresenter()
    }

    override fun initView() {
    }

    override fun showError(isShowing: Boolean) {
    }

    override fun showLoading(isShowing: Boolean) {
    }

    override fun showDetails() {
    }
}