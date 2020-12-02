package com.itmo.lab3belov

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class Pager : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        val layout = inflater.inflate(R.layout.pager, container, false);

        val pagerView = layout.findViewById<ViewPager2>(R.id.pagerView);
        pagerView.adapter = PagerAdapter(this);
        pagerView.currentItem = arguments!!.getInt("position");

        return layout;
    }

    class PagerAdapter(activity: Fragment) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 15;
        }

        override fun createFragment(position: Int): Fragment {
            val fragment = Card()
            val params = Bundle();
            params.putInt("position", position);
            fragment.arguments = params;
            return fragment;
        }
    }
}