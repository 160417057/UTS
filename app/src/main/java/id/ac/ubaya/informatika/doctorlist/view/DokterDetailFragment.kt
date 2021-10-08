package id.ac.ubaya.informatika.doctorlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.doctorlist.R
import id.ac.ubaya.informatika.doctorlist.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_dokter_detail.*


class DokterDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private  val dokterDetailAdapter = DokterDetailAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokter_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        viewModel.dokterDetailLD.observe(viewLifecycleOwner, Observer {
            txtNama.text = it.nama
            txtJabatan.text = it.jabatan
            txtPraktekDetail.text = it.praktek
            txtPhoneDetail.text = it.phone
            Picasso.get().load(it.photoUrl).into(imageViewDetail)
        })

    }
}