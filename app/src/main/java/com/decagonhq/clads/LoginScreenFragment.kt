package com.decagonhq.clads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.databinding.FragmentLoginScreenBinding
import com.google.android.material.textfield.TextInputEditText

class LoginScreenFragment : Fragment() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: Button

    private var _binding: FragmentLoginScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailEditText = binding.etEmailAddress
        passwordEditText = binding.etPassword
        loginButton = binding.btnLogin!!

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (Validator.validateEmail(email) && Validator.validatePassword(password)) {
                val action =
                    LoginFragmentDirections.actionLoginFragmentToBlankFragment(email, password)
                findNavController().navigate(action)
            } else {
                when {
                    !Validator.validatePassword(password) -> Toast.makeText(
                        requireContext(),
                        "Please input correct Email",
                        Toast.LENGTH_LONG
                    ).show()
                    !Validator.validateEmail(email) -> Toast.makeText(
                        requireContext(),
                        "Please input correct Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
