package com.aleksdark.taxiapp.presentation.screens.fragmentorderslist

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.adapter.OrdersAdapter
import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BaseView
import com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails.OrderDetailsView
import kotlinx.android.synthetic.main.error_layout.*
import kotlinx.android.synthetic.main.fragment_active_orders_list.*
import kotlinx.android.synthetic.main.loading_layout.*

class OrdersListView : BaseView<OrdersListPresenter>(), Contract.View {

    var adapter = OrdersAdapter()

    override fun showError(isShowing: Boolean) {
        error_layout.visibility = showView(isShowing)
    }

    override fun showLoading(isShowing: Boolean) {
        loading_layout.visibility = showView(isShowing)
    }

    private fun showView(isShowing: Boolean) : Int{
       return if (isShowing) View.VISIBLE else View.GONE
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_active_orders_list
    }

    override fun getPresenter(): OrdersListPresenter {
        return OrdersListPresenter()
    }

    override fun initView() {
        rv.layoutManager = LinearLayoutManager(context)
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rv.addItemDecoration(divider)
        adapter.onItemClick = {
            mPresenter?.onOrderClick(it)
        }
        rv.adapter = adapter

    }

    override fun showOrdersList(dataList: List<OrderModel>) {
        adapter.ordersList = dataList
        adapter.notifyDataSetChanged()
    }

    override fun goToFragment(order: OrderModel) {
        goToFragment(OrderDetailsView.newInstance(order))
    }
}