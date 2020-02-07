package developer.neel.com.bioxin.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import developer.neel.com.bioxin.R
import developer.neel.com.bioxin.databinding.ProductFragmentBinding

class ProductFragment : Fragment() {

    companion object {
        fun newInstance() = ProductFragment()
    }

    private lateinit var viewModel: ProductViewModel
    private lateinit var binding: ProductFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(
            inflater, R.layout.product_fragment, container, false)

        return binding.root

       // return inflater.inflate(R.layout.product_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        binding.viewModel= viewModel
        binding.lifecycleOwner = this



      //  setupListener()
       // observeViewModel()

    }

    override fun onStart() {
        super.onStart()

        viewModel.populateProductList()

        setupAdapter()

    }


    private fun setupAdapter() {

        viewModel.productResultList.observe(
            viewLifecycleOwner,
            Observer { userList ->
                viewModel.productGridAdapter.submitList(userList)

            }
        )


    }


}
