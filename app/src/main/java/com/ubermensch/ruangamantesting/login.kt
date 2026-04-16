package com.ubermensch.ruangamantesting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ubermensch.ruangamantesting.databinding.FragmentLoginBinding

class login : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // Fungsi untuk menyimpan data user
    private fun saveUserData(name: String, email: String) {
        val sharedPrefs = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        with(sharedPrefs.edit()) {
            putString("user_nama", name)
            putString("user_email", email)
            apply()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnLogin.setOnClickListener {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString().trim()

                if (email.isEmpty()) {
                    etEmail.error = "Email tidak boleh kosong"
                    return@setOnClickListener
                }

                if (password.isEmpty()) {
                    etPassword.error = "Kata sandi tidak boleh kosong"
                    return@setOnClickListener
                }

                // Ambil username dari email (teks sebelum @)
                val userName = email.substringBefore("@")
                
                // Simpan data ke SharedPreferences
                saveUserData(userName, email)

                Toast.makeText(requireContext(), "Berhasil masuk!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_login_to_home_page)
            }

            btnKeDaftar.setOnClickListener {
                findNavController().navigate(R.id.action_login_to_register)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}