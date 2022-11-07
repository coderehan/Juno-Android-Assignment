package com.rehan.junoandroidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.databinding.AdapterEmptyStateCryptoHoldingsBinding
import com.rehan.junoandroidassignment.models.CryptoHoldings

class EmptyStateCryptoHoldingsAdapter : RecyclerView.Adapter<EmptyStateCryptoHoldingsAdapter.ViewHolder>() {

    private var emptyStateCryptoHoldings = ArrayList<CryptoHoldings>()

    fun setEmptyStateCryptoHoldings(emptyStateCryptoHoldings : List<CryptoHoldings>){
        this.emptyStateCryptoHoldings = emptyStateCryptoHoldings as ArrayList<CryptoHoldings>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterEmptyStateCryptoHoldingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(emptyStateCryptoHoldings[position].logo)
            .into(holder.binding.ivLogo)

        holder.binding.tvTitle.text = emptyStateCryptoHoldings[position].title
    }

    override fun getItemCount(): Int {
        return emptyStateCryptoHoldings.size
    }

    inner class ViewHolder(val binding: AdapterEmptyStateCryptoHoldingsBinding) : RecyclerView.ViewHolder(binding.root)

}