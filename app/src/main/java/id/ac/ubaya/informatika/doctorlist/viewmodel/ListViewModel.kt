package id.ac.ubaya.informatika.doctorlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.Volley
import id.ac.ubaya.informatika.doctorlist.model.Dokter
import java.util.*



class ListViewModel:ViewModel() {
    val dokterLD = MutableLiveData<List<Dokter>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh(){
        val dokter1 = Dokter(nama = "Andrew",jabatan = "General Doktor",praktek = "ALK-Abello, Inc.",phone = "306-168-1170",photoUrl = "http://dummyimage.com/202x100.png/dddddd/000000")
        val dokter2 = Dokter(nama = "Elinore",jabatan = "Apoteker",praktek = "Pharmaceutical Associates, Inc.",phone = "371-368-3378",photoUrl = "http://dummyimage.com/128x100.png/cc0000/ffffff")
        val dokter3 = Dokter(nama = "Amii",jabatan = "Suster",praktek = "Physicians Total Care, Inc.",phone = "268-267-2188",photoUrl = "http://dummyimage.com/210x100.png/5fa2dd/ffffff")


        dokterLD.value = arrayListOf<Dokter>(dokter1,dokter2,dokter3)
        loadingErrorLD.value = false
        loadingLD.value = true

        //queue = Volley.newRequestQueue()
    }


}