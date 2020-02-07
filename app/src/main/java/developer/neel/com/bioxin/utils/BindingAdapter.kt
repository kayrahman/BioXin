package developer.neel.com.bioxin.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.databinding.BindingAdapter
import android.net.Uri
import androidx.core.widget.NestedScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.*
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import me.everything.android.ui.overscroll.VerticalOverScrollBounceEffectDecorator
import java.io.File



@BindingAdapter("adapterGrid")
fun setAdapterGrid(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
    val mLayoutManager = GridLayoutManager(view.context, 2)
    view.layoutManager = mLayoutManager
    val spanCount = 2 // 3 columns
    val spacing = 10 // 50px
    val includeEdge = false
    view.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
    // Vertical
    OverScrollDecoratorHelper.setUpOverScroll(view, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)
}

@BindingAdapter(value = ["bindingAdapter", "defaultRvLayout", "showDefaultDividerLine"], requireAll = false)
fun setBindingAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>, defaultLayout: Boolean?, showDefaultDividerLine: Boolean?) {
    if (defaultLayout != null && defaultLayout) {
        val mLayoutManager = LinearLayoutManager(view.context, LinearLayout.VERTICAL, false)
        view.layoutManager = mLayoutManager
        view.itemAnimator = DefaultItemAnimator()
        if (showDefaultDividerLine == true) {
            view.addItemDecoration(
                    DividerItemDecoration(view.context, LinearLayout.VERTICAL))
        }
        // Vertical
        OverScrollDecoratorHelper.setUpOverScroll(view, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)

    }
    view.adapter = adapter
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)
}


@BindingAdapter("imageUrlLocal")
fun setImageUrlLocal(imageView: ImageView, url: String?) {
    if (url!!.startsWith("http")) {
        Glide.with(imageView.context).load(url).into(imageView)
    } else {
        val imgFile = File(url)

        if (imgFile.exists()) {
            val imageUri = Uri.fromFile(imgFile)

            //load without library (performance issues)
//                val myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath())
//                iv_gallery.setImageBitmap(myBitmap)

            Glide.with(imageView.context)
                    .load(imageUri)
                    .into(imageView)
        }
    }
}


@BindingAdapter("customOverScroll")
fun setCustomOverScroll(view: ScrollView, overScroll: Boolean) {
    if(overScroll) {
        OverScrollDecoratorHelper.setUpOverScroll(view)
    }
}


