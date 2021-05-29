package com.chimemoo.gospacex.ui.main.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.chimemoo.gospacex.R
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.data.model.Launchpad
import com.chimemoo.gospacex.data.model.Launch
import com.chimemoo.gospacex.ui.base.UpcomingViewModelFactory
import com.chimemoo.gospacex.ui.main.viewmodel.UpcomingViewModel
import com.chimemoo.gospacex.utils.RetrofitProvider
import com.chimemoo.gospacex.utils.Status
import kotlinx.android.synthetic.main.upcoming_fragment.*

class UpcomingFragment : Fragment() {

    companion object {
        fun newInstance() = UpcomingFragment()
    }

    private lateinit var viewModel: UpcomingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.upcoming_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, UpcomingViewModelFactory(
            RetrofitProvider().ResourceService().create(
                ApiService::class.java))).get(UpcomingViewModel::class.java)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getUpcommingLaunch().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    setupUpcomingUI(it.data)
                    shimmer_card.visibility = View.GONE
                    detail_card_launch.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    shimmer_card.visibility = View.VISIBLE
                    shimmer_card.startShimmer()
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.getLaunchpad().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    setupLaunchPadUI(it.data)
                    shimmer_detail.visibility = View.GONE
                    detail_launch.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    shimmer_detail.visibility = View.VISIBLE
                    shimmer_detail.startShimmer()
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupUpcomingUI(data: Launch?) {
        context?.let { Glide.with(it).load(data?.link?.patch?.large).centerCrop().into(img_logo) }
        tv_launch_name.setText(data?.name)
        tv_launch_date.setText(data?.dateLocal)
    }

    fun setupLaunchPadUI(data: Launchpad?) {
        tv_launchpad_region.setText(data?.region)
        tv_launchpad_site.setText(data?.fullName)
        tv_launchpad_details.setText(data?.details)
    }

}