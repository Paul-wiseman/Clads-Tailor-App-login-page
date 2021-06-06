package com.decagonhq.clads.fragments.profilemanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decagonhq.clads.databinding.FragmentDashboardHomeBinding
import com.decagonhq.clads.databinding.FragmentDashboardMediaBinding


class DashboardMediaFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentDashboardMediaBinding.inflate(inflater).root
    }



}