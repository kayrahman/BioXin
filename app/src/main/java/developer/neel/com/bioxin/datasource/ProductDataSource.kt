package developer.neel.com.bioxin.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import developer.neel.com.bioxin.base.BaseRepo
import developer.neel.com.bioxin.model.Product
import developer.neel.com.bioxin.network.repository.PostRepo


class ProductDataSource(
   // val onAction: ( event: EventState) -> Unit

) : PageKeyedDataSource<Int,Product>() {

    val FIRST_PAGE : Int = 1

    val repo = PostRepo()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Product>
    ) {

        repo.getProduct(FIRST_PAGE,object : BaseRepo.RequestStatusCallBack{
            override fun startRequest() {


            }

            override fun endRequest() {


            }

            override fun <T> resultSuccess(results: T) {
                Log.d("search_result_initial",results.toString())
                //update search user list here

                var response = results as List<Product>

                var productList = response

                callback.onResult(productList, null, FIRST_PAGE + 1)
            }

            override fun <T> resultError(t: T) {
                Log.d("search_result_initial", t.toString())
                //  onAction(EventState.onError(t))}

            }
        })



    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Product>
    ) {


        repo.getProduct(params.key,object : BaseRepo.RequestStatusCallBack{
            override fun startRequest() {

            }

            override fun endRequest() {

            }

            override fun <T> resultSuccess(results: T) {
                Log.d("search_result",results.toString())
                //update search user list here

                var key = params.key + 1

                var productList = results as List<Product>

                callback.onResult(productList,key)


                Log.d("page_key_load_after",key.toString())


            }

            override fun <T> resultError(t: T) {
                //Log.d("search_result_after",t.toString())            }
                Log.d("search_result_after",t.toString())

               // onAction(EventState.onError(t))
            }

        })


    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Product>
    ) {

        repo.getProduct(params.key,object : BaseRepo.RequestStatusCallBack{
            override fun startRequest() {

            }

            override fun endRequest() {

            }

            override fun <T> resultSuccess(results: T) {
                Log.d("search_result",results.toString())
                //update search user list here

                var key = 0

                if(params.key >1){

                    key = params.key - 1

                }else{

                    key = params.key
                }


                var productList = results as List<Product>


                callback.onResult(productList,key)

                Log.d("page_key_load_before",key.toString())


            }

            override fun <T> resultError(t: T) {

              //  onAction(EventState.onError(t))

                Log.d("search_result_before",t.toString())            }

        })

    }
}