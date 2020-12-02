package com.itmo.lab3belov

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class Card : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        val layout = inflater.inflate(R.layout.card_layout, container, false)

        val versions = DataStorage.getVersionsList();

        val data = versions[arguments!!.getInt("position")];

        val poster = layout.findViewById<ImageView>(R.id.poster);
        val biopic = layout.findViewById<ImageView>(R.id.biopic);
        val name = layout.findViewById<TextView>(R.id.name);
        val date = layout.findViewById<TextView>(R.id.date);
        val desc = layout.findViewById<TextView>(R.id.desc);
        val btn = layout.findViewById<Button>(R.id.button);

        if (arguments != null) {
            poster.setImageResource(data.poster);
            biopic.setImageResource(data.imageAndroid);
            name.text = data.title;
            date.text = data.relDate;
            desc.text = data.desc;

            btn.setOnClickListener {
                val openUrl = Intent (Intent.ACTION_VIEW, Uri.parse(data.link));
                startActivity(openUrl);
            }
        }

        return layout
    }
}