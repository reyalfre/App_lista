package com.example.applista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListaFragment : Fragment(), DatoClick {
    private lateinit var  mAdapter: AdapterDato
    private lateinit var  mLinearLayout: LinearLayoutManager
    private lateinit var  lista: MutableList<Dato>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView= view.findViewById(R.id.recycler)
        rellenar()
        mAdapter = AdapterDato(lista, this)
        mLinearLayout = LinearLayoutManager(this.requireContext())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter=mAdapter

        }
    }
    fun rellenar(){
         lista= mutableListOf(
            Dato("nombre1", 10),
            Dato("nombre2", 20),
            Dato("nombre3", 30),
            Dato("nombre4", 40),
        )
    }

    override fun onClick(dato: Dato) {
        TODO("Not yet implemented")
    }

}