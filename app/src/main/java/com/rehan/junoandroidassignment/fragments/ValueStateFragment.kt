package com.rehan.junoandroidassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.R
import com.rehan.junoandroidassignment.adapters.AllTransactionsAdapter
import com.rehan.junoandroidassignment.adapters.CryptoPricesAdapter
import com.rehan.junoandroidassignment.adapters.EmptyStateCryptoHoldingsAdapter
import com.rehan.junoandroidassignment.adapters.ValueStateCryptoHoldingsAdapter
import com.rehan.junoandroidassignment.databinding.FragmentHomePageBinding
import com.rehan.junoandroidassignment.databinding.FragmentValueStateBinding
import com.rehan.junoandroidassignment.models.AllTransactions
import com.rehan.junoandroidassignment.models.CryptoHoldings
import com.rehan.junoandroidassignment.models.CryptoPrices
import com.rehan.junoandroidassignment.viewmodels.EmptyStateViewModel
import com.rehan.junoandroidassignment.viewmodels.ValueStateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ValueStateFragment : Fragment() {

    private var _binding: FragmentValueStateBinding? = null
    private val binding get() = _binding!!

    private lateinit var valueStateViewModel: ValueStateViewModel

    private lateinit var valueStateCryptoHoldingsAdapter : ValueStateCryptoHoldingsAdapter
    private lateinit var cryptoPricesAdapter: CryptoPricesAdapter
    private lateinit var allTransactionsAdapter: AllTransactionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentValueStateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        valueStateViewModel = ViewModelProvider(this)[ValueStateViewModel::class.java]
        valueStateViewModel.getValueCryptoBalance()
        valueStateViewModel.getValueCryptoHoldings()
        valueStateViewModel.getValueCryptoPrices()
        valueStateViewModel.getValueCryptoAllTransactions()

        prepareCryptoHoldingsRecyclerView()
        prepareCryptoPricesRecyclerView()
        prepareCryptoAllTransactionsRecyclerView()

        observeCryptoBalanceLiveData()
        observeCryptoHoldingsLiveData()
        observeCryptoPricesLiveData()
        observeCryptoAllTransactionsLiveData()

    }

    private fun prepareCryptoHoldingsRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        valueStateCryptoHoldingsAdapter = ValueStateCryptoHoldingsAdapter()
        binding.rvCryptoHoldings.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = valueStateCryptoHoldingsAdapter
        }
    }

    private fun prepareCryptoPricesRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        cryptoPricesAdapter = CryptoPricesAdapter()
        binding.rvCurrentPrices.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cryptoPricesAdapter
        }
    }

    private fun prepareCryptoAllTransactionsRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        allTransactionsAdapter = AllTransactionsAdapter()
        binding.rvRecentTransactions.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = allTransactionsAdapter
        }
    }

    private fun observeCryptoBalanceLiveData() {
        valueStateViewModel.cryptoBalanceLiveData.observe(viewLifecycleOwner, Observer {
            binding.valueState.tvCurrentBalanceUsd.visibility = View.VISIBLE
            Glide.with(this@ValueStateFragment)
                .load(it.your_crypto_holdings.logo)
                .into(binding.valueState.ivLogo)

            binding.valueState.tvTitle.text = it.title
            binding.valueState.tvSubTitle.text = it.subtitle
            binding.valueState.tvCurrentBalanceUsd.text = it.current_bal_in_usd
        })
    }

    private fun observeCryptoHoldingsLiveData() {
        valueStateViewModel.cryptoHoldingsLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            valueStateCryptoHoldingsAdapter.setValueStateCryptoHoldings(it)
        })
    }

    private fun observeCryptoPricesLiveData() {
        valueStateViewModel.cryptoPricesLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            cryptoPricesAdapter.setCryptoPricesList(it)
        })
    }

    private fun observeCryptoAllTransactionsLiveData() {
        valueStateViewModel.cryptoAllTransactionsLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            allTransactionsAdapter.setAllTransactionsList(it)
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}