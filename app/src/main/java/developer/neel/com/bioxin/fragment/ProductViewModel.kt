package developer.neel.com.bioxin.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import developer.neel.com.bioxin.adapter.product.ProductListGridAdapter
import developer.neel.com.bioxin.datasource.ProductDataSourceFactory
import developer.neel.com.bioxin.model.Product

class ProductViewModel : ViewModel() {

    val productGridAdapter = ProductListGridAdapter()

    lateinit var productResultList : LiveData<PagedList<Product>>
    lateinit var productListLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, Product>>



    fun populateProductList(){

        var factory = ProductDataSourceFactory()
        productListLiveDataSource = factory.productLiveDatasource

        productResultList = LivePagedListBuilder(factory,
            PagedList.Config.Builder()
                .setPageSize(100)
                .setEnablePlaceholders(true)
                .build()
        ).build() as LiveData<PagedList<Product>>

    }


}
