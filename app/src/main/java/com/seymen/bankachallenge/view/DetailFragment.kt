package com.seymen.bankachallenge.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.seymen.bankachallenge.R
import com.seymen.bankachallenge.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    lateinit var binding : FragmentDetailBinding
    var firebaseAnalytics = Firebase.analytics
    private val args: DetailFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        return binding.apply {
            val subeParcel = args.sube
            binding.secilenSube = subeParcel

            /* DATA BINDING İLE GEREKSİZ
            binding.twIDandBankaSube.text = "ID: ${subeParcel.ID}, ${subeParcel.bankaSube}"
            binding.twSehir.text = "${resources.getString(R.string.sehir)} ${subeParcel.bankaSehir}"
            binding.twIlce.text = "${resources.getString(R.string.ilce)}  ${subeParcel.bankaIlce}"
            binding.twBTip.text = "${resources.getString(R.string.bTipi)}  ${subeParcel.bankaTipi}"
            binding.twBKodu.text = "${resources.getString(R.string.bKodu)}  ${subeParcel.bankaKodu}"
            binding.twBPostaKodu.text = subeParcel.bankaPostaKodu
            binding.twBBKoordinatorlugu.text = "${resources.getString(R.string.bKoor)}  ${subeParcel.bankaKoord}"
            binding.twBOnOffline.text = "${resources.getString(R.string.line)}  ${subeParcel.bankaLine}"
            binding.twBOnOffSite.text = "${resources.getString(R.string.site)}  ${subeParcel.bankaSite}"
            binding.twBAdresAdi.text = "${resources.getString(R.string.adresAdi)}  ${subeParcel.bankaAdresAdi}"
            binding.twBEnYakinATM.text = "${resources.getString(R.string.enYakinATM)}  ${subeParcel.bankaEnYakinATM}"
            binding.twBAdres.text = "${resources.getString(R.string.adres)}  ${subeParcel.bankaAdres}"*/

            val logBundle = Bundle()
            logBundle.putInt("ID", subeParcel.ID)
            logBundle.putString("BankaSube", subeParcel.bankaSube)
            logBundle.putString("Sehir", subeParcel.bankaSehir)
            logBundle.putString("Ilçe", subeParcel.bankaIlce)
            logBundle.putString("BankaTipi", subeParcel.bankaTipi)
            logBundle.putString("BankaKodu", subeParcel.bankaKodu)
            logBundle.putString("PostaKodu", subeParcel.bankaPostaKodu)
            logBundle.putString("BolgeKoordinatorlugu", subeParcel.bankaKoord)
            logBundle.putString("LineDurumu", subeParcel.bankaLine)
            logBundle.putString("SiteDurumu", subeParcel.bankaSite)
            logBundle.putString("AdresAdi", subeParcel.bankaAdresAdi)
            logBundle.putString("EnYakinATM", subeParcel.bankaEnYakinATM)
            logBundle.putString("Adres", subeParcel.bankaAdres)
            firebaseAnalytics.logEvent("Tiklandi",logBundle)

        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.geriBtn.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMenuFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}