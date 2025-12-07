package com.asparrin.carlos.poketinder_2025_asparrin

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns

class RegisterViewModel(
    val context: Context
): ViewModel() {

    val inputsError = MutableLiveData<Boolean>()
    val emailFormatError = MutableLiveData<Boolean>()
    val passwordLengthError = MutableLiveData<Boolean>()
    val passwordsNotMatch = MutableLiveData<Boolean>()
    val userAlreadyExists = MutableLiveData<Boolean>()
    val registerSuccess = MutableLiveData<Boolean>()

    private var sharedPreferencesRepository: SharedPreferencesRepository =
        SharedPreferencesRepository().also {
            it.setSharedPreference(context)
        }

    fun validateInputs(email: String, password: String, confirmPassword: String) {
        // Validar campos vacíos
        if (isEmptyInputs(email, password, confirmPassword)) {
            inputsError.postValue(true)
            return
        }

        // Validar formato de email
        if (!isValidEmail(email)) {
            emailFormatError.postValue(true)
            return
        }

        // Validar longitud mínima de password
        if (password.length < 8) {
            passwordLengthError.postValue(true)
            return
        }

        // Validar que las contraseñas coincidan
        if (password != confirmPassword) {
            passwordsNotMatch.postValue(true)
            return
        }

        // Validar que el usuario no exista
        if (sharedPreferencesRepository.isUserRegistered(email)) {
            userAlreadyExists.postValue(true)
            return
        }

        // Guardar el nuevo usuario
        sharedPreferencesRepository.saveUserEmail(email)
        sharedPreferencesRepository.saveUserPassword(password)
        registerSuccess.postValue(true)
    }

    private fun isEmptyInputs(email: String, password: String, confirmPassword: String) = 
        email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
} 