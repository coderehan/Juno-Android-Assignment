package com.rehan.junoandroidassignment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rehan.junoandroidassignment.adapters.AllTransactionsAdapter
import com.rehan.junoandroidassignment.adapters.CryptoPricesAdapter
import com.rehan.junoandroidassignment.adapters.EmptyStateCryptoHoldingsAdapter
import com.rehan.junoandroidassignment.databinding.FragmentEmptyStateBinding
import com.rehan.junoandroidassignment.models.AllTransactions
import com.rehan.junoandroidassignment.models.CryptoHoldings
import com.rehan.junoandroidassignment.models.CryptoPrices
import com.rehan.junoandroidassignment.viewmodels.EmptyStateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmptyStateFragment : Fragment() {

    private var _binding: FragmentEmptyStateBinding? = null
    private val binding get() = _binding!!

    private lateinit var emptyStateViewModel : EmptyStateViewModel

    private lateinit var emptyStateCryptoHoldingsAdapter : EmptyStateCryptoHoldingsAdapter
    private lateinit var cryptoPricesAdapter: CryptoPricesAdapter
    private lateinit var allTransactionsAdapter: AllTransactionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEmptyStateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emptyStateViewModel = ViewModelProvider(this)[EmptyStateViewModel::class.java]
        emptyStateViewModel.getEmptyCryptoBalance()
        emptyStateViewModel.getEmptyCryptoHoldings()
        emptyStateViewModel.getEmptyCryptoPrices()
        emptyStateViewModel.getEmptyCryptoAllTransactions()

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
        emptyStateCryptoHoldingsAdapter = EmptyStateCryptoHoldingsAdapter()
        binding.rvCryptoHoldings.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = emptyStateCryptoHoldingsAdapter
        }
    }

    private fun prepareCryptoPricesRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        cryptoPricesAdapter = CryptoPricesAdapter()
        binding.rvCurrentPrices.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = cryptoPricesAdapter
        }
    }

    private fun prepareCryptoAllTransactionsRecyclerView() {
        binding.progressBar.visibility = View.VISIBLE
        allTransactionsAdapter = AllTransactionsAdapter()
        binding.rvRecentTransactions.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = allTransactionsAdapter
        }
    }

    private fun observeCryptoBalanceLiveData() {
        emptyStateViewModel.cryptoBalanceLiveData.observe(viewLifecycleOwner, Observer {
            binding.emptyState.btnDeposit.visibility = View.VISIBLE
            Glide.with(this@EmptyStateFragment)
                .load(it.your_crypto_holdings.logo)
                .into(binding.emptyState.ivLogo)

            binding.emptyState.tvTitle.text = it.title
            binding.emptyState.tvSubTitle.text = it.subtitle
            binding.emptyState.btnDeposit.setOnClickListener {
                Toast.makeText(requireActivity(), "You clicked Deposit button", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun observeCryptoHoldingsLiveData() {
        emptyStateViewModel.cryptoHoldingsLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            emptyStateCryptoHoldingsAdapter.setEmptyStateCryptoHoldings(it)
        })
    }

    private fun observeCryptoPricesLiveData() {
        emptyStateViewModel.cryptoPricesLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            cryptoPricesAdapter.setCryptoPricesList(it)
        })
    }

    private fun observeCryptoAllTransactionsLiveData() {
        emptyStateViewModel.cryptoAllTransactionsLiveData.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = View.GONE
            allTransactionsAdapter.setAllTransactionsList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}