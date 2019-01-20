package com.aleksdark.taxiapp.presentation.screens.fragmentorderslist

import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.adapter.OrdersAdapter
import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BaseView
import kotlinx.android.synthetic.main.fragment_active_orders_list.*

class OrdersListView: BaseView<OrdersListPresenter>(), Contract.View {

    var adapter = OrdersAdapter()

    override fun showError(isShowing: Boolean) {

    }

    override fun showLoading(isShowing: Boolean) {

    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_active_orders_list
    }

    override fun getPresenter(): OrdersListPresenter {
        return OrdersListPresenter()
    }

    override fun initView() {
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = adapter
    }

    override fun showOrdersList(dataList: List<OrderModel>) {
        adapter.ordersList = dataList
        adapter.notifyDataSetChanged()
    }

}