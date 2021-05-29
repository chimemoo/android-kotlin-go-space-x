package com.chimemoo.gospacex.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chimemoo.gospacex.R
import com.chimemoo.gospacex.data.model.Rocket
import kotlinx.android.synthetic.main.item_card.view.img_logo
import kotlinx.android.synthetic.main.item_card_rocket.view.*

class RocketAdapter(private val listRocket: List<Rocket>) :
    RecyclerView.Adapter<RocketAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLogo = itemView.img_logo
        val tvRocketName = itemView.tv_rocket_name
        val tvActive = itemView.tv_active
        val tvInactive = itemView.tv_inactive
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RocketAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_rocket, parent, false)
        return RocketAdapter.ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RocketAdapter.ListViewHolder, position: Int) {
        val rocket: Rocket = listRocket.get(position)

        Glide.with(holder.itemView.context)
            .load(rocket.flickrImages?.get(0))
            .override(100, 100)
            .fitCenter()
            .into(holder.imgLogo)

        holder.tvRocketName.setText(rocket.name)
        if(rocket.active) {
            holder.tvActive.visibility = View.VISIBLE
            holder.tvInactive.visibility = View.GONE
        } else {
            holder.tvActive.visibility = View.GONE
            holder.tvInactive.visibility =View.VISIBLE
        }

    }

    override fun getItemCount(): Int {
        return listRocket.count()
    }
}