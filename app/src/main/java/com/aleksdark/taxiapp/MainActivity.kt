package com.aleksdark.taxiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aleksdark.taxiapp.presentation.screens.fragmentorderslist.OrdersListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToFragment()
    }

    private fun goToFragment() {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.content_container, OrdersListView())
                commit()
            }
    }
}
