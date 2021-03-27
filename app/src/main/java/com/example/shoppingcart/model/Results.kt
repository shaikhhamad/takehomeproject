package com.example.shoppingcart.model

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("results")
var products: List<Product>? = null)
