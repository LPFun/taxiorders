package com.aleksdark.taxiapp.repository.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StartAddress {
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null

}