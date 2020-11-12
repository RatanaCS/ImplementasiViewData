package com.sumuzu.implementasiviewdata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.implementasiviewdata.R
import com.sumuzu.implementasiviewdata.model.Yamaha

class AdapterRecycleView (
    private val context: Context,
    private val data: ArrayList<Yamaha>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterRecycleView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int = data?.size ?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item : Yamaha? = data?.get(position)

        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.view.setOnClickListener {
            itemClick.detailData(item)
        }

    }

    inner class ViewHolder(val view :   View) : RecyclerView.ViewHolder(view){

        val foto = view.findViewById<ImageView>(R.id.ivImage)
        val nama = view.findViewById<TextView>(R.id.tvNama)

    }

    interface OnClickListener {
        fun detailData(item: Yamaha?)
    }

}