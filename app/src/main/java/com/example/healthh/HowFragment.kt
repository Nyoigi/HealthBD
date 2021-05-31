package com.example.healthh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healthh.DB.DBHelper
import com.example.healthhome.DB.ModelData
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_how, container, false)

        var dbHelper : DBHelper = DBHelper(view.context)
        var list: MutableList<ModelData> = dbHelper.showData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ItemAdapter(requireContext(),list) { }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            findNavController().navigate(R.id.action_howFragment_to_askHowFragment)
        }
    }

}