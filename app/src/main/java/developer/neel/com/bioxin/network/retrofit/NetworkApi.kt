package developer.neel.com.bioxin.network.retrofit

import android.media.Image
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcResponse
import developer.neel.com.bioxin.model.Media
import developer.neel.com.bioxin.model.Post
import developer.neel.com.bioxin.model.Product
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.io.File


/**
 * The interface which provides methods to get result of webservices
 */
interface NetworkApi {

    @GET("product")
    fun getPosts(): Observable<MutableList<Post>>



    @GET("product")
    fun getProduct(): Observable<MutableList<Product>>


    @GET("media/{media_id}")
    fun getMedia(@Path("media_id")media_id:Int): Observable<Media>



}
