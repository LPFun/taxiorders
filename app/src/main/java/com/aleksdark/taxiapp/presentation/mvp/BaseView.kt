package com.aleksdark.taxiapp.presentation.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.aleksdark.taxiapp.R

abstract class BaseView<P : MvpPresenter> : Fragment(), MvpView {

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected var mPresenter: P? = null

    abstract fun getPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = getPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter?.attachView(this)
        initView()

        mPresenter?.viewIsReady()
    }

    abstract fun initView()


    override fun onDestroyView() {
        super.onDestroyView()
        if (isRemoving)
            mPresenter?.destroy()
        mPresenter?.detachView()

    }

    open fun goToFragment(fragment: Fragment){
        fragmentManager!!.beginTransaction()
            .apply {
                replace(R.id.content_container, fragment)
                addToBackStack(null)
                commit()
            }
    }
}