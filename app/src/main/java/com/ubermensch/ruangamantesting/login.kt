package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etEmail    = view.findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = view.findViewById<TextInputEditText>(R.id.etPassword)
        val btnLogin   = view.findViewById<MaterialButton>(R.id.btnLogin)
        val btnKeDaftar = view.findViewById<MaterialButton>(R.id.btnKeDaftar)

        // Tombol Masuk → Home Page
        btnLogin.setOnClickListener {
            val email    = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = "Kata sandi tidak boleh kosong"
                return@setOnClickListener
            }

            // TODO: Tambahkan autentikasi nyata di sini
            Toast.makeText(requireContext(), "Berhasil masuk!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_login_to_home_page)
        }

        // Tombol Buat Akun Baru → Register
        btnKeDaftar.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }
}