package com.aleksdark.taxiapp.repository.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Vehicle {

    @SerializedName("regNumber")
    @Expose
    var regNumber: String? = null
    @SerializedName("modelName")
    @Expose
    var modelName: String? = null
    @SerializedName("photo")
    @Expose
    var photo: String? = null
    @SerializedName("driverName")
    @Expose
    var driverName: String? = null

}