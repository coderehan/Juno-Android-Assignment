package com.rehan.junoandroidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.databinding.AdapterCryptoPricesBinding
import com.rehan.junoandroidassignment.databinding.AdapterValueStateCryptoHoldingsBinding
import com.rehan.junoandroidassignment.models.CryptoHoldings
import com.rehan.junoandroidassignment.models.CryptoPrices

class CryptoPricesAdapter : RecyclerView.Adapter<CryptoPricesAdapter.ViewHolder>() {

    private var cryptoPricesList = ArrayList<CryptoPrices>()

    fun setCryptoPricesList(cryptoPricesList : List<CryptoPrices>){
        this.cryptoPricesList = cryptoPricesList as ArrayList<CryptoPrices>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterCryptoPricesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(cryptoPricesList[position].logo)
            .into(holder.binding.ivLogo)

        holder.binding.tvTitle.text = cryptoPricesList[position].title
        holder.binding.tvCurrentPrice.text = cryptoPricesList[position].current_price_in_usd
    }

    override fun getItemCount(): Int {
        return cryptoPricesList.size
    }

    inner class ViewHolder(val binding: AdapterCryptoPricesBinding) : RecyclerView.ViewHolder(binding.root)

}