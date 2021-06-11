package com.decagonhq.clads.fragments.profilemanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.decagonhq.clads.adapters.AddClientViewPagerAdapter
import com.decagonhq.clads.databinding.FragmentAddClientBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AddClientFragment : Fragment() {

    // using  view binding to inflate the layout file
    private var _binding: FragmentAddClientBinding? = null
    private val binding get() = _binding!!

    private lateinit var tabLayout: TabLayout

    private lateinit var add_client_viewpager2: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // getting a reference of the tablayout from the layout file
        tabLayout = binding.addClientFragmentTabLayout

        // getting a reference of the viewpager2 from layout file
        add_client_viewpager2 = binding.addClientFragmentViewPager

        // connecting the viewpager with the adapter
        // An instance of the the viewpager adapter class
         var adapter = AddClientViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle
        )
        add_client_viewpager2.adapter = adapter

        // tablayout setup with the viewpager to show the different fragments as tabs
        TabLayoutMediator(tabLayout,add_client_viewpager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Client Account"
                }
                1 -> {
                    tab.text = "Measurement"
                }
                2 -> {
                    tab.text = "Delivery Address"
                }
            }
        }.attach()
    }







}

