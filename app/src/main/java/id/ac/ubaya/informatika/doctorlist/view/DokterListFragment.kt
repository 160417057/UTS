package id.ac.ubaya.informatika.doctorlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.doctorlist.R
import id.ac.ubaya.informatika.doctorlist.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_dokter_list.*


class DokterListFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val dokterListAdapter = DokterListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokter_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()


        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = dokterListAdapter

        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.dokterLD.observe(viewLifecycleOwner, Observer {
            dokterListAdapter.updateDokterlist(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if (it) {
                txtError.visibility = View.VISIBLE
            } else{
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it){
                progressLoad.visibility = View.VISIBLE
                recView.visibility = View.GONE
            } else{
                progressLoad.visibility = View.GONE
                recView.visibility = View.VISIBLE
            }
        })
    }
}