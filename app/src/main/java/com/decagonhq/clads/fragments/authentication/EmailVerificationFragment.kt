package com.decagonhq.clads.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentEmailVerificationBinding

class EmailVerificationFragment : Fragment() {

    // using binding
    private var preBinding: FragmentEmailVerificationBinding? = null
    private val binding: FragmentEmailVerificationBinding get() = preBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        preBinding = FragmentEmailVerificationBinding.inflate(inflater, container, false)
        return preBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // to navigate to the login activity
        binding.emailVerificationFragmentVerifyEmailAddressButton.setOnClickListener {
            findNavController().navigate(R.id.action_emailVerificationFragment_to_loginFragment)
        }
    }
}
