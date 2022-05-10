package com.seymen.bankachallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.seymen.bankachallenge.databinding.ItemMenuBinding
import com.seymen.bankachallenge.model.SubeBilgileriModel
import com.seymen.bankachallenge.view.MenuFragmentDirections
import java.util.*

class RecyclerVAdapter(private val subeListesi : ArrayList<SubeBilgileriModel>,private val subeStringIsimler:ArrayList<String>) : RecyclerView.Adapter<RecyclerVAdapter.ViewHolder>() , Filterable{

    var countryFilterList  = ArrayList<String>()
    var modelArrayList = ArrayList<SubeBilgileriModel>()

    class ViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    init {
        countryFilterList  = subeStringIsimler
        modelArrayList = subeListesi
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // data binding
        holder.binding.model = modelArrayList[position]
        holder.binding.executePendingBindings()

       // holder.binding.textviewRecycler.text = countryFilterList[position]
        with(modelArrayList[position]){
            // Log.e("filterlist içi", subeFilterList[5].toString())
              holder.binding.cwRecycler.setOnClickListener {
                  val sube = SubeBilgileriModel(ID,bankaSehir,bankaIlce,holder.binding.textviewRecycler.text.toString(),bankaTipi,bankaKodu,bankaAdresAdi,bankaAdres,bankaPostaKodu,bankaLine,bankaSite,bankaKoord,bankaEnYakinATM)
                  val action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(sube)
                 Navigation.findNavController(it).navigate(action)
              }
        }
    }
    override fun getItemCount() : Int = countryFilterList.size

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
            val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    countryFilterList  = subeStringIsimler
                    modelArrayList = subeListesi
                } else {
                    val resultList = ArrayList<String>()
                    val modelList = ArrayList<SubeBilgileriModel>()

                    for (i in 0 until subeStringIsimler.size) {
                        if (subeStringIsimler[i].toLowerCase(Locale.getDefault()).contains(charSearch.toLowerCase(Locale.getDefault()))) {
                            resultList.add(subeStringIsimler[i])
                            modelList.add(subeListesi[i])
                        }
                    }
                    modelArrayList = modelList
                    countryFilterList  = resultList

                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                countryFilterList  = (p1?.values as ArrayList<String>)
                notifyDataSetChanged()

            }
        }
    }
}