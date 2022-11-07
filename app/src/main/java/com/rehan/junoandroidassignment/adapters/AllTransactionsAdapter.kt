package com.rehan.junoandroidassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.databinding.AdapterAllTransactionsBinding
import com.rehan.junoandroidassignment.databinding.AdapterCryptoPricesBinding
import com.rehan.junoandroidassignment.models.AllTransactions
import com.rehan.junoandroidassignment.models.CryptoPrices

class AllTransactionsAdapter : RecyclerView.Adapter<AllTransactionsAdapter.ViewHolder>() {

    private var allTransactionsList = ArrayList<AllTransactions>()

    fun setAllTransactionsList(allTransactionsList : List<AllTransactions>){
        this.allTransactionsList = allTransactionsList as ArrayList<AllTransactions>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterAllTransactionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(allTransactionsList[position].txn_logo)
            .into(holder.binding.ivLogo)

        holder.binding.tvTitle.text = allTransactionsList[position].title
        holder.binding.tvTime.text = allTransactionsList[position].txn_time
        holder.binding.tvAmount.text = allTransactionsList[position].txn_amount
        holder.binding.tvSubAmount.text = allTransactionsList[position].txn_sub_amount
    }

    override fun getItemCount(): Int {
        return allTransactionsList.size
    }

    inner class ViewHolder(val binding: AdapterAllTransactionsBinding) : RecyclerView.ViewHolder(binding.root)

}