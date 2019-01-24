package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import android.os.Bundle
import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BaseView
import com.google.gson.Gson

class OrderDetailsView : BaseView<Contract.Presenter>(), Contract.View {

    private var mOrder = OrderModel()

    companion object {
        private val ORDER = "ORDER"
        fun newInstance(order: OrderModel): OrderDetailsView {
            val args = Bundle()
            args.putString(ORDER, Gson().toJson(order))
            val fragment = OrderDetailsView()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        bundle?.let {
            mOrder = Gson().fromJson(bundle.getString(ORDER), OrderModel::class.java)
        }
    }

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