package com.decagonhq.clads.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentForgotPasswordBinding
import com.decagonhq.clads.utils.ForgotPasswordFragmentsValidationObject

class ForgotPasswordFragment : Fragment() {
    // declaring binding variables
    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.forgotPasswordFragmentRequestPasswordButton.setOnClickListener {
            val email =
                binding.forgotPasswordFragmentEmailEdittext.text.toString()
            if (ForgotPasswordFragmentsValidationObject.validateEmail(
                    email
                )
            ) {
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_resetPasswordVerification)
            } else {
                Toast.makeText(requireContext(), "Not a valid email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
