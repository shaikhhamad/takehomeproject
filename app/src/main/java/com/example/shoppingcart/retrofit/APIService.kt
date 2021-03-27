package com.example.shoppingcart.retrofit

import com.example.shoppingcart.model.Product
import com.example.shoppingcart.model.Results
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("default/dynamodb-writer")
    fun getResults(
    ): Call<Results>

}