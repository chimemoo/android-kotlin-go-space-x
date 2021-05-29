package com.chimemoo.gospacex.ui.main.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.chimemoo.gospacex.R
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.ui.base.LaunchesViewModelFactory
import com.chimemoo.gospacex.ui.main.adapter.LaunchesAdapter
import com.chimemoo.gospacex.ui.main.viewmodel.LaunchesViewModel
import com.chimemoo.gospacex.utils.RetrofitProvider
import com.chimemoo.gospacex.utils.Status
import kotlinx.android.synthetic.main.launches_fragment.*

class LaunchesFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchesFragment()
    }

    private lateinit var viewModel: LaunchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.launches_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, LaunchesViewModelFactory(
            RetrofitProvider().ResourceService().create(
                ApiService::class.java))
        ).get(LaunchesViewModel::class.java)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getAllLaunches().observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    shimmer_list_card.visibility = View.GONE
                    rv_launches.visibility = View.VISIBLE
                    rv_launches.layoutManager = LinearLayoutManager(context)
                    val launchesAdapter: LaunchesAdapter? = it.data?.let { data -> LaunchesAdapter(data) }
                    rv_launches.adapter = launchesAdapter
                    launchesAdapter?.notifyDataSetChanged()
                }
                Status.LOADING -> {
                    shimmer_list_card.visibility = View.VISIBLE
                    shimmer_list_card.startShimmer()
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}