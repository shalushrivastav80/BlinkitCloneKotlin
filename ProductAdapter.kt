package com.example.blinkitclone.adapter


import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkitclone.R
import com.example.blinkitclone.model.Product

class ProductAdapter(
    private val list: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tvName)
        val price = view.findViewById<TextView>(R.id.tvPrice)
        val image = view.findViewById<ImageView>(R.id.imgProduct)
        val add = view.findViewById<Button>(R.id.btnAdd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]

        holder.name.text = product.name
        holder.price.text = "₹${product.price}"
        holder.image.setImageResource(product.image)


        holder.add.setOnClickListener {
            product.quantity++
            Toast.makeText(holder.itemView.context,
                "${product.name} added",
                Toast.LENGTH_SHORT).show()
        }
    }
}