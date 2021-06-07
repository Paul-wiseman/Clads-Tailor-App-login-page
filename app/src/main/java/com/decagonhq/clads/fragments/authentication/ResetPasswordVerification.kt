package com.decagonhq.clads.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentResetPasswordVerificationBinding

class ResetPasswordVerification : Fragment() {
    // delaring binding varibles
    var _binding: FragmentResetPasswordVerificationBinding? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResetPasswordVerificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setting reset password button on clicklistener
        binding.resetPasswordVerificationFragmentResetPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_resetPasswordVerification_to_resetPassword)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
