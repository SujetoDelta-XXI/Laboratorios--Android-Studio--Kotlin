package com.asparrin.carlos.poketinder_2025_asparrin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asparrin.carlos.poketinder_2025_asparrin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerViewModel = RegisterViewModel(this)
        observeValues()
        setupClickListeners()
    }

    private fun observeValues() {
        registerViewModel.inputsError.observe(this) {
            Toast.makeText(this, getString(R.string.error_complete_data), Toast.LENGTH_SHORT).show()
        }

        registerViewModel.emailFormatError.observe(this) {
            Toast.makeText(this, getString(R.string.error_invalid_email), Toast.LENGTH_SHORT).show()
        }

        registerViewModel.passwordLengthError.observe(this) {
            Toast.makeText(this, getString(R.string.error_password_length), Toast.LENGTH_SHORT).show()
        }

        registerViewModel.passwordsNotMatch.observe(this) {
            Toast.makeText(this, getString(R.string.error_passwords_not_match), Toast.LENGTH_SHORT).show()
        }

        registerViewModel.userAlreadyExists.observe(this) {
            Toast.makeText(this, getString(R.string.error_user_exists), Toast.LENGTH_SHORT).show()
        }

        registerViewModel.registerSuccess.observe(this) {
            Toast.makeText(this, getString(R.string.success_registration), Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            registerViewModel.validateInputs(
                email = binding.edtEmail.text.toString(),
                password = binding.edtPassword.text.toString(),
                confirmPassword = binding.edtPassword2.text.toString()
            )
        }

        binding.btnBackClose.setOnClickListener {
            finish()
        }

        // Botón "Ya tengo una cuenta"
        binding.btnAlreadyHaveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
} 