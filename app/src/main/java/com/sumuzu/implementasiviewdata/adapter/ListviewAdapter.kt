package com.sumuzu.implementasiviewdata.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.sumuzu.implementasiviewdata.R
import com.sumuzu.implementasiviewdata.model.Yamaha

class ListviewAdapter(private val context: Context, private val data: ArrayList<Yamaha>?) :BaseAdapter() {

    override fun getCount(): Int = data?.size ?: 0

    override fun getItem(position: Int): Any {
        return data?.get(position) ?: 0
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)

        val nama = view.findViewById<TextView>(R.id.tvNama)
        val foto = view.findViewById<ImageView>(R.id.ivImage)

        val item:Yamaha? = data?.get(position)

        nama.text = item?.nama
        foto.setImageResource(item?.foto ?:0)

        return view
    }
}