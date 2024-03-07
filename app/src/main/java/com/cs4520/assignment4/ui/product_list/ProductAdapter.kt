package com.cs4520.assignment4.ui.product_list

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.model.Product
import com.cs4520.assignment4.R


class ProductAdapter(private val dataSet: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val holder: View
        val productName: TextView
        val date: TextView
        val price: TextView

        init {
            imageView = view.findViewById(R.id.image)
            productName = view.findViewById(R.id.productName)
            date = view.findViewById(R.id.expDate)
            price = view.findViewById(R.id.price)
            holder = view.findViewById(R.id.holder)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_activity_row_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val product = dataSet[position]
        if (this.validProduct(product)) {

            viewHolder.productName.text = product.name
            viewHolder.date.isVisible = false
            product.expiryDate?.let {
                viewHolder.date.text = product.expiryDate
                viewHolder.date.isVisible = true
            }
            viewHolder.price.text = dataSet[position].price.toString()
            if (product.type == "Equipment") {

                viewHolder.holder.setBackgroundColor(Color.parseColor("#E06666"))
                viewHolder.imageView.setImageResource(R.drawable.equipment)

            } else {
                viewHolder.holder.setBackgroundColor(Color.parseColor("#FFD965"))
                viewHolder.imageView.setImageResource(R.drawable.food)
            }

        }

    }

    private fun validProduct(product: Product): Boolean {
        return product.name.isNotEmpty() && product.type.isNotEmpty() && product.price.isNotEmpty()

    }

    override fun getItemCount() = dataSet.size

}