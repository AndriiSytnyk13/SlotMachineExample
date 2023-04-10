package com.sytyy.com.jetscomview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sytyy.com.databinding.ItemBetWinBinding
import com.sytyy.com.jetscommodel.PayTable

class JetscomPayTableAdapter : RecyclerView.Adapter<JetscomViewHolder>() {

    private val payTableItems = PayTable.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JetscomViewHolder =
        JetscomViewHolder(
            ItemBetWinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = payTableItems.size

    override fun onBindViewHolder(holder: JetscomViewHolder, position: Int) =
        holder.bindViews(payTableItems[position])

}