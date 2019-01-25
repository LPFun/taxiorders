package com.aleksdark.taxiapp.presentation.screens.fragmentordersdetails

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import com.aleksdark.taxiapp.R
import com.aleksdark.taxiapp.presentation.models.OrderModel
import com.aleksdark.taxiapp.presentation.mvp.BaseView
import com.aleksdark.taxiapp.repository.entities.OrdersImgResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_orders_detail.*
import java.io.IOException
import java.net.URL

class OrderDetailsView : BaseView<Contract.Presenter>(), Contract.View {
    override fun showDetails(orderModel: OrderModel, ordersImgResponse: OrdersImgResponse) {
        try {
            val url = URL("http://www.roxiemobile.ru/careers/test/images/01.jpg")
            details_imv.setImageBitmap(BitmapFactory.decodeStream(url.openConnection().getInputStream()))
//            image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        } catch (e: IOException) {
            Log.e(this::class.java.simpleName, "Error", e)
        }
//        details_imv.setImageBitmap(ordersImgResponse.bitmap)
        details_from.text = ordersImgResponse.error
    }

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
        mPresenter?.onViewIsReady(mOrder)
    }

    override fun showError(isShowing: Boolean) {
    }

    override fun showLoading(isShowing: Boolean) {
    }

}