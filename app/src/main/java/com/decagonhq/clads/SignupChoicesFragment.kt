package com.decagonhq.clads

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.decagonhq.clads.databinding.FragmentSignupChoicesBinding

class SignupChoicesFragment : Fragment() {
    // Declare binding variable
    private var _binding: FragmentSignupChoicesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupChoicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentSignupChoicesTextviewHaveAccount.setOnClickListener {
        }

        binding.fragmentSignupChoicesButtonWithEmail.apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_signupChoicesFragment_to_signupEmailFragment2)
            }
        }
        binding.fragmentSignupChoicesButtonWithGoogle.apply {
            setOnClickListener {
                findNavController().navigate(R.id.action_signupChoicesFragment_to_signupGoogleFragment2)
            }
        }
        signUpChoicesHaveAccountTextView()
    }

    /**This function programmatically applies styles to the Have an account? Login textview,
     * in the Signup Choices Fragment. The styles are color, typeface and weight.
     * */
    private fun signUpChoicesHaveAccountTextView() {
        // Create a Spannable string object
        val spannableString = SpannableString("Have an account? Login")

        // Set color to have an account textview
        val haveAccountTextColor = ForegroundColorSpan(Color.LTGRAY)
        spannableString.setSpan(haveAccountTextColor, 0, 16, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        // Set color to login textview
        val loginTextColor = ForegroundColorSpan(Color.WHITE)
        spannableString.setSpan(loginTextColor, 17, 22, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        // Set text to bold
        val styleSpanOfLoginTextView = StyleSpan(Typeface.BOLD)
        spannableString.setSpan(styleSpanOfLoginTextView, 17, 22, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        //
        val styleSpanOfHaveAccountView = StyleSpan(Typeface.NORMAL)
        spannableString.setSpan(styleSpanOfHaveAccountView, 0, 16, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        // Bind the view
        binding.fragmentSignupChoicesTextviewHaveAccount.text = spannableString
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
