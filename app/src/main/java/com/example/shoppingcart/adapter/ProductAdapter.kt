package com.example.shoppingcart.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.R
import com.example.shoppingcart.ViewProductActivity
import com.example.shoppingcart.helper.Constants
import com.example.shoppingcart.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product_row_item.view.*

class ProductAdapter(val context: Context, var products: List<Product> = arrayListOf()) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.ViewHolder {
        // The layout design used for each list item
        val view = LayoutInflater.from(context).inflate(R.layout.product_row_item, null)
        return ViewHolder(view,context)

    }
    // This returns the size of the list.
    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(viewHolder: ProductAdapter.ViewHolder, position: Int) {
        //we simply call the `bindProduct` function here
        viewHolder.bindProduct(products[position])
    }

    class ViewHolder(view: View,val context: Context) : RecyclerView.ViewHolder(view) {

        // This displays the product information for each item
        fun bindProduct(product: Product) {

            itemView.product_name.text = product.name
            itemView.product_price.text = product.price.toString()
            Picasso.get().load(product.thumbnail[0]).fit().into(itemView.product_image)
            itemView.setOnClickListener{
                val intent = Intent(context, ViewProductActivity::class.java)
                intent.putExtra(Constants.NAME, product.name)
                intent.putExtra(Constants.PRICE, product.price)
                intent.putExtra(Constants.CREATED_AT, product.createdAt)
                intent.putExtra(Constants.PHOTO, product.photos[0])
                startActivity(context,intent,null)
            }
        }

    }

}