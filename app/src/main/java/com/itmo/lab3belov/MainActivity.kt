package com.itmo.lab3belov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = Tile.newInstance(supportFragmentManager);

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, list).addToBackStack("list").commit();

    }

}