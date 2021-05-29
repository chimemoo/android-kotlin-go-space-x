package com.chimemoo.gospacex.ui.main.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.chimemoo.gospacex.R
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.ui.base.RocketViewModelFactory
import com.chimemoo.gospacex.ui.main.adapter.RocketAdapter
import com.chimemoo.gospacex.ui.main.viewmodel.RocketsViewModel
import com.chimemoo.gospacex.utils.RetrofitProvider
import com.chimemoo.gospacex.utils.Status
import kotlinx.android.synthetic.main.launches_fragment.*
import kotlinx.android.synthetic.main.rockets_fragment.*
import kotlinx.android.synthetic.main.rockets_fragment.shimmer_list_card

class RocketsFragment : Fragment() {

    companion object {
        fun newInstance() = RocketsFragment()
    }

    private lateinit var viewModel: RocketsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rockets_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, RocketViewModelFactory(
            RetrofitProvider().ResourceService().create(
                ApiService::class.java
            )
        )).get(RocketsViewModel::class.java)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getRockets().observe(viewLifecycleOwner, {
            when(it.status) {
                Status.SUCCESS -> {
                    shimmer_list_card.visibility = View.GONE
                    rv_rockets.visibility = View.VISIBLE
                    rv_rockets.layoutManager = LinearLayoutManager(context)
                    val rocketAdapter: RocketAdapter? = it.data?.let { data -> RocketAdapter(data) }
                    rv_rockets.adapter = rocketAdapter
                    rocketAdapter?.notifyDataSetChanged()
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