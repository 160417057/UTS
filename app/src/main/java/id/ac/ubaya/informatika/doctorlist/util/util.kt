package id.ac.ubaya.informatika.doctorlist.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.doctorlist.R
import java.lang.Exception

fun ImageView.LoadImage(url:String, progressBar: ProgressBar){
    Picasso.get().load(url).resize(400,400)
            .centerCrop().error(R.drawable.ic_baseline_error_24).into(this,
                    object: Callback {
                        override fun onSuccess() {
                            progressBar.visibility = View.GONE
                        }

                        override fun onError(e: Exception?) {
                            progressBar.visibility = View.VISIBLE
                        }

                    })
}