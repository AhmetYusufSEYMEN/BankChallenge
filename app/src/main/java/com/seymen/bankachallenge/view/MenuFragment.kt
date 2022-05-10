package com.seymen.bankachallenge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.seymen.bankachallenge.R
import com.seymen.bankachallenge.adapter.RecyclerVAdapter
import com.seymen.bankachallenge.databinding.FragmentMenuBinding
import com.seymen.bankachallenge.model.SubeBilgileriModel
import com.seymen.bankachallenge.viewmodel.BaseViewModel

class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: BaseViewModel
    private lateinit var subeRecyclerAdapter : RecyclerVAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[BaseViewModel::class.java]
        viewModel.getDataVM()

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.mainRecyclerView.setHasFixedSize(true)

        if (viewModel.isNetworkAvailable(requireContext())){
            observeLiveData()
        }
        else{
            Toast.makeText(requireContext(), resources.getString(R.string.hataMesaji), Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
            binding.citySearch.visibility = View.GONE
        }

        binding.citySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                if(::subeRecyclerAdapter.isInitialized){ // initialize kontrolü
                    subeRecyclerAdapter.filter.filter(newText)
                }
                return false
            }
        })
    }


    fun observeLiveData() {
        viewModel.subeler.observe(viewLifecycleOwner) { subeler ->
            subeler?.let {
                binding.mainRecyclerView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
                binding.twHata.visibility = View.GONE
                binding.citySearch.visibility = View.VISIBLE
                val stringList = ArrayList<String>()
                for (sube in subeler){
                    stringList.add(sube.bankaSube)
                }
                subeRecyclerAdapter = RecyclerVAdapter(subeler as ArrayList<SubeBilgileriModel>,stringList)
                binding.mainRecyclerView.adapter = subeRecyclerAdapter
                subeRecyclerAdapter.notifyDataSetChanged()
            }
        }

        viewModel.hataMesaji.observe(viewLifecycleOwner) { hataMesaji ->
            hataMesaji?.let {
                if (hataMesaji == true) {
                    binding.mainRecyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    binding.twHata.visibility = View.VISIBLE
                    binding.citySearch.visibility = View.GONE

                } else {
                    binding.twHata.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.yukleniyormuPB.observe(viewLifecycleOwner) {
            it?.let {
                if (it == true) {
                    binding.twHata.visibility = View.INVISIBLE
                    binding.mainRecyclerView.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }
}