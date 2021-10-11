package uz.uzinfocom.e_imzo_kotlin_sdk.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.uzinfocom.e_imzo_kotlin_sdk.R
import uz.uzinfocom.e_imzo_kotlin_sdk.models.EriModel

class EriAdapter(val context: Context) : RecyclerView.Adapter<EriAdapter.ViewHolder>() {

    var listEri: ArrayList<EriModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_eri, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  = holder.onBind()

    override fun getItemCount() = listEri.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txt1: TextView = view.findViewById(R.id.txtCardEri1)
        val txt2: TextView = view.findViewById(R.id.txtCardEri2)

        fun onBind(){
            txt1.text = listEri[adapterPosition].name
            txt2.text = listEri[adapterPosition].password
        }
    }

    fun submit(list: List<EriModel>) {
        listEri.clear()
        listEri.addAll(list)
    }
}