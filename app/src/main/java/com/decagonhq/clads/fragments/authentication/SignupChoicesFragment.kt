package com.decagonhq.clads.fragments.authentication

import android.content.Intent
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
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentSignupChoicesBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import timber.log.Timber

class SignupChoicesFragment : Fragment() {

    private lateinit var googleSignInClient: GoogleSignInClient
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
                findNavController().navigate(R.id.action_signupChoicesFragment_to_signupEmailFragment)
            }
        }

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), googleSignInOptions)

        binding.fragmentSignupChoicesButtonWithGoogle.apply {
            setOnClickListener {
                signIn()
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

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        if (account != null) {
            moveTo(R.id.signup_email_fragment)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == REQUEST_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Timber.d("firebaseAuthWithGoogle: ${account.id}")
                account.email?.let { updateUi(it) }
            } catch (e: ApiException) {
                Toast.makeText(
                    requireContext(), "Login Failed: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, REQUEST_SIGN_IN)
    }

    private fun updateUi(email: String) {
        val userEmail = email
        val action =
            SignupChoicesFragmentDirections.actionSignupChoicesFragmentToSignupEmailFragment()
        moveTo(action)
    }

    companion object {
        private var REQUEST_SIGN_IN = 100
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

fun Fragment.moveTo(id: Int) {
    findNavController().navigate(id)
}

fun Fragment.moveTo(direction: NavDirections) {
    findNavController().navigate(direction)
}
