package id.ac.ubaya.informatika.doctorlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.doctorlist.model.Dokter

class DetailViewModel:ViewModel() {
    val dokterDetailLD = MutableLiveData<Dokter>()


    fun  fetch(){
        val dokter1 = Dokter(nama = "Andrew",jabatan = "General Doktor",praktek = "ALK-Abello, Inc.",phone = "306-168-1170",photoUrl = "http://dummyimage.com/202x100.png/dddddd/000000")

        dokterDetailLD.value = dokter1

    }
}