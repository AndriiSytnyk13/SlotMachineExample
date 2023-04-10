package com.sytyy.com.jetscomview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sytyy.com.databinding.ItemBetWinBinding
import com.sytyy.com.jetscommodel.PayTable

class JetscomViewHolder(private val itemBinding: ItemBetWinBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bindViews(payTable: PayTable) {
        itemBinding.apply {
            image1.setImageResource(payTable.image1)
            image2.setImageResource(payTable.image2)
            payTable.image3?.let { image3.setImageResource(it) }
            payTextview.text = payTable.pay.toString()
        }
    }
}