package com.decagonhq.clads.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.decagonhq.clads.R
import com.decagonhq.clads.databinding.FragmentSignupEmailBinding
import com.decagonhq.clads.utils.SignUpEmailFragmentValidator

class SignupEmailFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentSignupEmailBinding
    lateinit var itemSelected: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemSelected = parent?.getItemAtPosition(position) as String
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    private fun setUpUI() {

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.email_sign_up_fragment_choose_account_category_array,
            R.layout.signup_email_autotextview
        ).also { adapter -> // Specifies the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.emailSignUpFragmentAccountCategoryAutoTextView.setAdapter(adapter) // Applies the adapter to the spinner
        }
        binding.emailSignUpFragmentAccountCategoryAutoTextView.onItemSelectedListener = this

//        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.signup_email_autotextview,resources.getStringArray(R.array.clads_user_category))
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.accountCategoryFilledDropdown.setAdapter(arrayAdapter)
        binding.emailSignUpFragmentSignUpButton.apply {
            setOnClickListener {
                if (validateFields()) {
                    findNavController().navigate(R.id.action_signupEmailFragment_to_emailVerificationFragment)
                }
            }
        }
    }

    private fun validateFields(): Boolean {

        var isFieldValidated = true

        when {
            (!SignUpEmailFragmentValidator.nameValidator(binding.emailSignUpFragmentFirstnameTextInputEditText.text.toString())) ->
                {
                    binding.emailSignUpFragmentFirstnameTextInputLayout.error = "Field is empty or invalid name format entered"
                    isFieldValidated = false
                }
            else -> {
                binding.emailSignUpFragmentFirstnameTextInputLayout.error = ""
            }
        }

        if (!SignUpEmailFragmentValidator.nameValidator(binding.emailSignUpFragmentLastnameTextInputEditText.text.toString())) {
            binding.emailSignUpFragmentLastnameTextInputLayout.error = "Field is empty or invalid name format entered"
            isFieldValidated = false
        }

        if (!SignUpEmailFragmentValidator.emailValidator(
                binding.emailSignUpFragmentEmailAddressTextInputEditText.text.toString().trim()
            )
        ) {
            binding.emailSignUpFragmentEmailAddressTextInputLayout.error = "Field is empty or Invalid email address entered"
            isFieldValidated = false
        }

        if (!SignUpEmailFragmentValidator.accountCategoryValidator(binding.emailSignUpFragmentAccountCategoryAutoTextView.text.toString())) {

            binding.emailSignUpFragmentAccountCategoryTextInputLayout.error = "Select an account type"
            isFieldValidated = false
        }

        if (!SignUpEmailFragmentValidator.passwordValidator(
                binding.emailSignUpFragmentConfirmPasswordTextInputEditText.text.toString().trim()
            )
        ) {
            binding.emailSignUpFragmentPasswordTextInputLayout.error = "Password must not be less than 6 digits"
            binding.emailSignUpFragmentPasswordTextInputLayout.errorIconDrawable = null
            isFieldValidated = false
        }

        if (!SignUpEmailFragmentValidator.passwordValidator(
                binding.emailSignUpFragmentConfirmPasswordTextInputEditText.text.toString().trim()
            )
        ) {
            binding.emailSignUpFragmentConfirmPasswordTextInputLayout.error = "Password must not be less than 6 digits"
            binding.emailSignUpFragmentConfirmPasswordTextInputLayout.errorIconDrawable = null
            isFieldValidated = false
        }

        if (!SignUpEmailFragmentValidator.passwordsMatcher(
                binding.emailSignUpFragmentPasswordTextInputEditText.text.toString(),
                binding.emailSignUpFragmentConfirmPasswordTextInputEditText.text.toString()
            )

        ) {

            binding.emailSignUpFragmentConfirmPasswordTextInputLayout.error = "Passwords do not match"
            binding.emailSignUpFragmentConfirmPasswordTextInputLayout.errorIconDrawable = null
            isFieldValidated = false
        }

        return isFieldValidated
    }
}
