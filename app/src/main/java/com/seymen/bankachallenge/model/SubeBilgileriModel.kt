package com.seymen.bankachallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class SubeBilgileriModel(
    @SerializedName("ID")
    val ID: Int,

    @SerializedName("dc_SEHIR")
    val bankaSehir: String = "",

    @SerializedName("dc_ILCE")
    val bankaIlce: String = "",

    @SerializedName("dc_BANKA_SUBE")
    val bankaSube: String = "",

    @SerializedName("dc_BANKA_TIPI")
    val bankaTipi: String = "",

    @SerializedName("dc_BANK_KODU")
    val bankaKodu: String = "",

    @SerializedName("dc_ADRES_ADI")
    val bankaAdresAdi: String = "",

    @SerializedName("dc_ADRES")
    val bankaAdres: String = "",

    @SerializedName("dc_POSTA_KODU")
    val bankaPostaKodu: String = "",

    @SerializedName("dc_ON_OFF_LINE")
    val bankaLine: String = "",

    @SerializedName("dc_ON_OFF_SITE")
    val bankaSite: String = "",

    @SerializedName("dc_BOLGE_KOORDINATORLUGU")
    val bankaKoord: String = "",

    @SerializedName("dc_EN_YAKIM_ATM")
    val bankaEnYakinATM: String = "",
) : Parcelable {
    /*@IgnoredOnParcel
    private val deneme = ApplicationContext().getAppContext().getString(R.string.veriBulunamadi)

    var bankaSehir: String
        get() = dc_SEHIR.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaIlce: String
        get() = dc_ILCE.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaSube: String
        get() = dc_BANKA_SUBE.ifEmpty { deneme }
        set(_) {}
    var bankaTipi: String
        get() = dc_BANKA_TIPI.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaKodu: String
        get() = dc_BANK_KODU.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaAdresAdi: String
        get() = dc_ADRES_ADI.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaAdres: String
        get() = dc_ADRES.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaPostaKodu: String
        get() = dc_POSTA_KODU.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaLine: String
        get() = dc_ON_OFF_LINE.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaSite: String
        get() = dc_ON_OFF_SITE.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaKoord: String
        get() = dc_BOLGE_KOORDINATORLUGU.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}
    var bankaEnYakinATM: String
        get() = dc_EN_YAKIM_ATM.ifEmpty { "Veri Bulunamadı!" }
        set(_) {}

*/
}