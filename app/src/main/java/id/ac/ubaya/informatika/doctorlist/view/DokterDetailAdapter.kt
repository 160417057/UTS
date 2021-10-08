package id.ac.ubaya.informatika.doctorlist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.doctorlist.R
import id.ac.ubaya.informatika.doctorlist.model.Dokter
import id.ac.ubaya.informatika.doctorlist.util.LoadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*
import kotlinx.android.synthetic.main.dokter_list_item.view.txtJabatan
import kotlinx.android.synthetic.main.dokter_list_item.view.txtNama
import kotlinx.android.synthetic.main.fragment_dokter_detail.view.*

class DokterDetailAdapter(val dokterList:ArrayList<Dokter>):RecyclerView.Adapter<DokterDetailAdapter.DokterViewHolder>() {
    class DokterViewHolder(val view: View):RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v= inflater.inflate(R.layout.dokter_list_item,parent,false)

        return DokterViewHolder(v)
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        holder.view.txtNama.text = dokterList[position].nama
        holder.view.txtJabatan.text = dokterList[position].jabatan
        holder.view.txtPraktekDetail.text = dokterList[position].praktek
        holder.view.txtPhoneDetail.text = dokterList[position].phone
        holder.view.imageViewDetail.LoadImage(dokterList[position].photoUrl.toString(),holder.view.progressBar)

        holder.view.btnBack.setOnClickListener {
            val action = DokterDetailFragmentDirections.actionDokterList()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }


}