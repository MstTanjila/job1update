package com.alamin.job1xm
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.productImage)
        private val productId: TextView = itemView.findViewById(R.id.idTxt)
        private val productName: TextView = itemView.findViewById(R.id.nametxt)
        private val productPrice: TextView = itemView.findViewById(R.id.pricetxt)
        private val creationat: TextView = itemView.findViewById(R.id.creationAt)
        private val updateat: TextView = itemView.findViewById(R.id.updateAt)
        private val description: TextView = itemView.findViewById(R.id.desTxt)
        fun bind(product: Product) {
            Glide.with(itemView)
                .load(product.images[0])
                .into(productImage)
            productName.text = product.title
            creationat.text = product.creationAt
            updateat.text = product.updatedAt
            description.text = product.description
            productId.text=product.id
            productPrice.text = "$${product.price}"
        }
    }
}