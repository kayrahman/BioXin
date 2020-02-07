package developer.neel.com.bioxin.adapter.product


import androidx.recyclerview.widget.DiffUtil
import developer.neel.com.bioxin.model.Product


class ProductListDiffUtilCallback : DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
}