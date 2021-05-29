package com.chimemoo.gospacex.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chimemoo.gospacex.R
import com.chimemoo.gospacex.data.model.Launch
import kotlinx.android.synthetic.main.item_card.view.*
import kotlinx.android.synthetic.main.upcoming_fragment.*

class LaunchesAdapter(private val listLauch: List<Launch>) : RecyclerView.Adapter<LaunchesAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLogo = itemView.img_logo
        val tvLaunchName = itemView.tv_launch_name
        val tvLaunchDate = itemView.tv_launch_date
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val launch: Launch = listLauch.get(position)
        Glide.with(holder.itemView.context)
            .load(launch.link.patch?.large)
            .override(100, 100)
            .fitCenter()
            .into(holder.imgLogo)
        holder.tvLaunchName.setText(launch.name)
        holder.tvLaunchDate.setText(launch.dateLocal)
    }

    override fun getItemCount(): Int {
        return listLauch.count()
    }
}