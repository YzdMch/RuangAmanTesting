package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ubermensch.ruangamantesting.databinding.FragmentRegisterBinding

class register : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inisialisasi binding yang benar
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menggunakan with(binding) untuk memanggil ID secara langsung
        with(binding) {

            // Tombol Back → kembali ke Login
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            // Link "Sudah punya akun?" → Login
            tvKeLogin.setOnClickListener {
                findNavController().navigateUp()
            }

            // Tombol Daftar → Validasi dan Navigasi
            btnDaftar.setOnClickListener {
                val email = etEmailRegister.text.toString().trim()
                val password = etPasswordRegister.text.toString().trim()
                val konfirmasi = etKonfirmasiPassword.text.toString().trim()

                // Validasi input
                if (email.isEmpty()) {
                    etEmailRegister.error = "Email tidak boleh kosong"
                    return@setOnClickListener
                }
                if (password.isEmpty()) {
                    etPasswordRegister.error = "Kata sandi tidak boleh kosong"
                    return@setOnClickListener
                }
                if (password != konfirmasi) {
                    etKonfirmasiPassword.error = "Kata sandi tidak cocok"
                    return@setOnClickListener
                }
                if (!cbSyarat.isChecked) {
                    Toast.makeText(requireContext(), "Harap setujui syarat dan ketentuan", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Berhasil
                Toast.makeText(requireContext(), "Pendaftaran berhasil!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_register_to_form_data_user)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Penting untuk mencegah memory leak
    }
}