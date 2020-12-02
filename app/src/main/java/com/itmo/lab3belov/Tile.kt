package com.itmo.lab3belov

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class Tile(fm: FragmentManager) : Fragment() {
    private val kek = fm;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)
        val layout = inflater.inflate(R.layout.list, container, false)

        val android = DataStorage.getVersionsList();

        val context = container!!.context;

        val adapter = Adapter(context, android ) {
            position -> val temp = position;
            val fragment = Pager();
            val params = Bundle();
            params.putInt("position", position);
            fragment.arguments = params;
            
            kek.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("pager").commit();

        };

        val list = layout.findViewById<RecyclerView>(R.id.androidList);
        list.adapter = adapter;

        val decoration = DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL);
        decoration.setDrawable(ContextCompat.getDrawable(context, R.color.teal_200)!!);
        list.addItemDecoration(decoration)

        return layout
    }

    companion object {
        fun newInstance(fm: FragmentManager): Tile {
            return Tile(fm);
        }
    }
}