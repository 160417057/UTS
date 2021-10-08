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
import java.util.*

class DokterListAdapter(val dokterList:ArrayList<Dokter>):RecyclerView.Adapter<DokterListAdapter.DokterViewHolder>() {
    class DokterViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateDokterlist(newDokterList:List<Dokter>){
        dokterList.clear()
        dokterList.addAll(newDokterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v= inflater.inflate(R.layout.dokter_list_item,parent,false)

        return DokterViewHolder(v)
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        holder.view.txtNama.text = dokterList[position].nama
        holder.view.txtJabatan.text = dokterList[position].jabatan
        holder.view.imageView.LoadImage(dokterList[position].photoUrl.toString(),holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener {
            val action = DokterListFragmentDirections.actionDokterDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dokterList.size
    }
}