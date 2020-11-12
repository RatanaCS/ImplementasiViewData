package com.sumuzu.implementasiviewdata

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.sumuzu.implementasiviewdata.adapter.AdapterRecycleView
import com.sumuzu.implementasiviewdata.model.Yamaha
import kotlinx.android.synthetic.main.activity_implementasi_recycle_view.*

class ImplementasiRecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementasi_recycle_view)

        val listYamaha = ArrayList<Yamaha>()
        listYamaha.add(Yamaha("Mio M3","Matic", 16000000, R.drawable.mio125))
        listYamaha.add(Yamaha("Lexi 125","Matic", 19000000, R.drawable.lexi))
        listYamaha.add(Yamaha("Aerox 155 VVA","Matic", 24000000, R.drawable.aerox155))
        listYamaha.add(Yamaha("Nmax Non ABS","Matic", 29560000, R.drawable.nmax_red))
        listYamaha.add(Yamaha("Xmax","Matic", 65000000, R.drawable.xmax))
        listYamaha.add(Yamaha("MX King 150","Moped", 18000000, R.drawable.mxking150))

        recycle.adapter =AdapterRecycleView(this, listYamaha, object : AdapterRecycleView.OnClickListener{
            override fun detailData(item: Yamaha?) {
                Dialog(this@ImplementasiRecycleView).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_item)

                    val image = this.findViewById<ImageView>(R.id.ivDetail)
                    val nama = this.findViewById<TextView>(R.id.tvNama)
                    val type = this.findViewById<TextView>(R.id.tvType)
                    val harga = this.findViewById<TextView>(R.id.tvHarga)
                    val close = this.findViewById<Button>(R.id.btClose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = item?.nama
                    type.text = item?.type
                    harga.text = "Rp. ${item?.harga},-"

                    close.setOnClickListener {
                        this.dismiss()
                    }
                }.show()

            }
        })

    }
}