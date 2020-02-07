package developer.neel.com.bioxin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import developer.neel.com.bioxin.base.BaseRepo
import developer.neel.com.bioxin.fragment.ProductFragment
import developer.neel.com.bioxin.network.repository.PostRepo

private const val PRODUCT_FRAGMENT = "PRODUCT_FRAGMENT"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val view = supportFragmentManager.findFragmentByTag(PRODUCT_FRAGMENT) as ProductFragment?
            ?: ProductFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.root_activity_main, view, PRODUCT_FRAGMENT)
            .commitNowAllowingStateLoss()

/*

        val repo =  PostRepo()
        repo.getProduct(object : BaseRepo.RequestStatusCallBack{
            override fun startRequest() {


            }

            override fun endRequest() {

            }

            override fun <T> resultSuccess(results: T) {

                Log.d("result_success",results.toString())
            }

            override fun <T> resultError(t: T) {

                Log.d("result_error",t.toString())

            }

        })
*/


    }








}
