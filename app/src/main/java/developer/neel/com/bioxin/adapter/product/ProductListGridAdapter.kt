package developer.neel.com.bioxin.adapter.product

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import developer.neel.com.bioxin.R
import developer.neel.com.bioxin.base.BaseRepo
import developer.neel.com.bioxin.databinding.ItemProductListBinding
import developer.neel.com.bioxin.model.Media
import developer.neel.com.bioxin.model.Product
import developer.neel.com.bioxin.network.repository.PostRepo


class ProductListGridAdapter : PagedListAdapter<Product, ProductListItemViewHolder>(ProductListDiffUtilCallback())  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListItemViewHolder {

        val binding: ItemProductListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_product_list, parent, false)

        return ProductListItemViewHolder(binding)

    }


    override fun onBindViewHolder(holder: ProductListItemViewHolder, position: Int) {

        getItem(position).let { product ->

            holder.bind(product!!)
            initImages(product.featured_media,holder)

            holder.binding.clyFreshFindsItem.setOnClickListener {
                listener?.onItemClick(product)
            }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.binding.imvListItem.clipToOutline = true

            }
        }







    }

    private fun initImages(
        featuredMedia: Int,
        holder: ProductListItemViewHolder
    ) {
        val repo = PostRepo()
        repo.getMedia(featuredMedia, object : BaseRepo.RequestStatusCallBack{
            override fun startRequest() {


            }

            override fun endRequest() {

            }

            override fun <T> resultSuccess(results: T) {
                //show the image here

                val mediaResponse = results as Media

                Log.d("media_response",mediaResponse.media_details.sizes.thumbnail.source_url)

               // (media.getMedia_details().getSizes().getLarge().getSource_url())

                Glide.with(holder.itemView.context)
                    .load(mediaResponse.media_details.sizes.medium.source_url)
                    .apply(
                        RequestOptions()
                            .fitCenter()
                    )
                    .apply(RequestOptions.skipMemoryCacheOf(false))
                    .into(holder.binding.imvListItem)


            }

            override fun <T> resultError(t: T) {

                Log.d("media_response",t.toString())

            }


        })

    }


}


    class ProductListItemViewHolder(val binding : ItemProductListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ProductListAdapterViewModel()

        fun bind(item : Product){
            viewModel.bind(item)
            binding.viewModel = viewModel

        }

    }


    /**
     * listener class related
     */
    var listener: AdapterListener? = null

    interface AdapterListener {
        fun onItemClick(product : Product)



}













