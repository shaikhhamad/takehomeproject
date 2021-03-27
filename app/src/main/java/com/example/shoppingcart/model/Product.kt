package com.example.shoppingcart.model

import com.google.gson.annotations.SerializedName
data class Product(
    @SerializedName("name")
    var name: String? = null,

    @SerializedName("price")
    var price: String? = null,

    @SerializedName("created_at")
    var createdAt: String? = null,

    @SerializedName("uid")
    var id: String? = null,
    @SerializedName("image_ids")
    var imageId: List<String> = arrayListOf(),


    @SerializedName("image_urls")
    var photos: List<String> = arrayListOf(),

    @SerializedName("image_urls_thumbnails")
    var thumbnail: List<String> = arrayListOf()

)