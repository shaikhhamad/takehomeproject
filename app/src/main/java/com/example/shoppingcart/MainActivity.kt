package com.example.shoppingcart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingcart.adapter.ProductAdapter
import com.example.shoppingcart.model.Product
import com.example.shoppingcart.model.Results
import com.example.shoppingcart.retrofit.APIConfig
import com.example.shoppingcart.retrofit.APIService
import retrofit2.Call
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: APIService
    private lateinit var productAdapter: ProductAdapter

    private var products = listOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)
        apiService = APIConfig.getRetrofitClient(this).create(APIService::class.java)
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.purple_500))
        swipeRefreshLayout.isRefreshing = true
        // assign a layout manager to the recycler view
        products_recyclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        getProducts()
    }


    fun getProducts() {
        apiService.getResults().enqueue(object : retrofit2.Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                print(t.message)
                Log.d("Data error", t.message)
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                swipeRefreshLayout.isRefreshing = false
                if(response.body()!=null){
                    var results=response.body()
                        products= results!!.products!!
                }
                productAdapter = ProductAdapter(this@MainActivity, products)
                products_recyclerview.adapter = productAdapter
                productAdapter.notifyDataSetChanged()
            }
        })
    }

}