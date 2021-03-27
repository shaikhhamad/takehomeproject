package com.example.shoppingcart

import android.app.ActionBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingcart.helper.Constants
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_product.*


class ViewProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_product)
        val intent = intent

        val price = intent.getStringExtra(Constants.PRICE)
        val name = intent.getStringExtra(Constants.NAME)
        val createdAt = intent.getStringExtra(Constants.CREATED_AT)
        val photo = intent.getStringExtra(Constants.PHOTO)
        product_name.text=name
        product_price.text=price
        product_created.text=createdAt
        Picasso.get().load(photo).fit().into(product_image)
        val actionBar: ActionBar? = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}