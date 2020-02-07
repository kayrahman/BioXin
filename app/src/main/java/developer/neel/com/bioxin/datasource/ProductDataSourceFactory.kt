package developer.neel.com.bioxin.datasource


import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import developer.neel.com.bioxin.model.Product


class ProductDataSourceFactory() : DataSource.Factory<Int,Product>() {

    private var productDataSource: MutableLiveData<PageKeyedDataSource<Int, Product>> = MutableLiveData()
    val productLiveDatasource: MutableLiveData<PageKeyedDataSource<Int, Product>> get() = productDataSource



    override fun create(): ProductDataSource {
        val dataSource = ProductDataSource()
        productDataSource.postValue(dataSource)
        return dataSource

    }


}