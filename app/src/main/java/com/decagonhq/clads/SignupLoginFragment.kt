package com.decagonhq.clads

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.databinding.FragmentSignupLoginBinding

class SignupLoginFragment : Fragment(R.layout.fragment_signup_login) {

    // Declare binding variable
    private var fragmentSignupLoginBinding: FragmentSignupLoginBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSignupLoginBinding.bind(view)
        fragmentSignupLoginBinding = binding

        // Initialize binding variables
        binding.fragmentSignupSignupButton.setOnClickListener {
            val action = SignupLoginFragmentDirections.actionSignupLoginFragmentToSignupChoicesFragment()
            findNavController().navigate(action)
        }
    }
}
