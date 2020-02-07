package developer.neel.com.bioxin.network.repository

import developer.justory.com.testkotlin.network.retrofit.NetworkModule
import developer.neel.com.bioxin.base.BaseRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostRepo : BaseRepo(){

    /**
     * call API to get post
     */
    fun getPosts(requestStatusCallBack: RequestStatusCallBack) {
        val networkApi = NetworkModule.networkApi
        networkApi.getPosts()
            //observe performance of scheduler
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { requestStatusCallBack.startRequest() }
            .doOnTerminate { requestStatusCallBack.endRequest() }
            .subscribe(
                { result -> requestStatusCallBack.resultSuccess(result) },
                { t -> requestStatusCallBack.resultError(t) }
            )
    }


    fun getProduct(page_num:Int,requestStatusCallBack: RequestStatusCallBack) {
        val networkApi = NetworkModule.networkApi
        networkApi.getProduct()
            //observe performance of scheduler
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { requestStatusCallBack.startRequest() }
            .doOnTerminate { requestStatusCallBack.endRequest() }
            .subscribe(
                { result -> requestStatusCallBack.resultSuccess(result) },
                { t -> requestStatusCallBack.resultError(t) }
            )
    }


    fun getMedia(featured_media:Int,requestStatusCallBack: RequestStatusCallBack){
        val networkApi = NetworkModule.networkApi
        networkApi.getMedia(featured_media)
            //observe performance of scheduler
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { requestStatusCallBack.startRequest() }
            .doOnTerminate { requestStatusCallBack.endRequest() }
            .subscribe(
                { result -> requestStatusCallBack.resultSuccess(result) },
                { t -> requestStatusCallBack.resultError(t) }
            )

    }








}