package developer.neel.com.bioxin.adapter.product


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import developer.neel.com.bioxin.model.Product


class ProductListAdapterViewModel {
    private val productItem = MutableLiveData<Product>()

    fun bind(product: Product) {
        this.productItem.value = product

    }



    fun getTitle(): String? {
        return productItem.value?.title?.rendered.toString()
    }



}