package com.aleksdark.taxiapp.repository.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Price {
    @SerializedName("amount")
    @Expose
    var amount: Int? = null
    @SerializedName("currency")
    @Expose
    var currency: String? = null
}