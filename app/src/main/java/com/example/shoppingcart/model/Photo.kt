package com.example.shoppingcart.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("filename")
    var filename: String? = null
)