package com.example.applista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applista.databinding.ItemDatoBinding

class AdapterDato(var listaDatos: MutableList<Dato>, var listener: DatoClick) :
    RecyclerView.Adapter<AdapterDato.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemDatoBinding.bind(view)

        fun bind(dato: Dato) {
            binding.textView.text = dato.name
            binding.textViewEdad.text = dato.edad.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //mContext = parent.context //iniciamos el contexto

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_dato, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dato = listaDatos.get(position)
        holder.bind(dato)
        holder.itemView.setOnClickListener { listener.onClick(dato) }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
}