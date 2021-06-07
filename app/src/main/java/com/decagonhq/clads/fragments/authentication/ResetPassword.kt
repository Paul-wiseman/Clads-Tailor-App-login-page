package com.decagonhq.clads.fragments.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentResetPasswordBinding
import com.decagonhq.clads.utils.ForgotPasswordFragmentsValidationObject

class ResetPassword : Fragment() {

    // declaring binding variables
    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         *setting reset password button on clicklistener
         * validating the passwords to check if they are the same
         * setting the action to navigate to the next fragment if the passwords are the same
         */

        binding.resetPasswordFragmentResetPasswordButton.setOnClickListener {
            var passwordOne = binding.resetPasswordFragmentNewPasswordEdittext.text.toString()
            val passwordTwo =
                binding.resetPasswordFragmentConfirmNewPasswordEdittext.text.toString()
            if (ForgotPasswordFragmentsValidationObject.validatePasswords(
                    passwordOne,
                    passwordTwo
                )
            ) {
                findNavController().navigate(R.id.action_resetPassword_to_loginFragment)
            } else {
                Toast.makeText(requireContext(), "Passwords do not correspond", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
