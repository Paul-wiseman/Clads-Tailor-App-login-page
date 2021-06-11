package com.decagonhq.clads.fragments.profilemanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decagonhq.clads.adapters.ClientListAdapter
import com.decagonhq.clads.databinding.FragmentClientsListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ClientsListFragment : Fragment() {

    // using  view binding to inflate the layout file
    private var _binding: FragmentClientsListBinding? = null
    private val binding get() = _binding!!

    // male and female image view to be displayed when the clients list is empty
    // together with "You have not added client yet text"
    private lateinit var maleImage: ImageView
    private lateinit var femaleImage: ImageView
    private lateinit var noClientText: TextView
    private lateinit var addButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView

    // An instance of the the viewpager adapter class
    private val adapter = ClientListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentClientsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // getting a reference of the views in the layout file
        recyclerView = binding.fragmentClientsListRecyclerview
        maleImage = binding.fragmentClientsListMaleImageview
        femaleImage = binding.fragmentClientsListFemaleImageview
        noClientText = binding.fragmentClientsListYouHaveNotAddedClientYetTextView

        addButton = binding.fragmentClientListFloatingActionButton

        addButton.setOnClickListener {
            val action = ClientsListFragmentDirections.actionClientsListFragmentToAddClientFragment()
            findNavController().navigate(action)
        }

        // setting up the layout manager for the recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // connecting the adapter to the recyclerview
        recyclerView.adapter = adapter

        displayRecyclerviewOrNoClientText()
    }

    // this function checks the recyclerview and if the list is empty a
    // "You have not added client yet text" is displayed
    private fun displayRecyclerviewOrNoClientText() {
        if (adapter.itemCount == 0) {
            maleImage.isVisible = true
            femaleImage.isVisible = true
            noClientText.isVisible = true
        } else {

            maleImage.isVisible = false
            femaleImage.isVisible = false
            noClientText.isVisible = false
        }
    }
}
