package com.decagonhq.clads.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.decagonhq.clads.databinding.FragmentLoginScreenBinding
import com.decagonhq.clads.utils.LoginScreenFragmentValidator
import com.google.android.material.textfield.TextInputEditText

class LoginScreenFragment : Fragment() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var newUserTextview: TextView
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

        // getting the reference of the user input edit text
        emailEditText = binding.fragmentLoginScreenEmailAddressTextInputEditText
        passwordEditText = binding.fragmentLoginScreenPasswordTextInputEditText
        loginButton = binding.fragmentLoginScreenLoginButton
        newUserTextview = binding.fragmentLoginScreenNewUserTextView
        textSpan()
        /* Onclick of the login button the user's input is converted to string and validated and if the user's
        *  input is correct the next fragment is launched else the user is notified which field is not
        * field properly
        */

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (LoginScreenFragmentValidator.validateEmail(email) && LoginScreenFragmentValidator.validatePassword(
                    password
                )
            ) {
            } else {
                when {
                    !LoginScreenFragmentValidator.validatePassword(password) -> Toast.makeText(
                        requireContext(),
                        "Please input correct password",
                        Toast.LENGTH_LONG
                    ).show()
                    !LoginScreenFragmentValidator.validateEmail(email) -> Toast.makeText(
                        requireContext(),
                        "Please input correct Email",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    // this function is used to programmatically change the color style of a text in the layout file
    private fun textSpan() {
        val spannableString = SpannableString("New User? SignUp for free")
        val fcolor = ForegroundColorSpan(Color.WHITE)
        spannableString.setSpan(fcolor, 10, 25, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        newUserTextview.text = spannableString
    }
}
