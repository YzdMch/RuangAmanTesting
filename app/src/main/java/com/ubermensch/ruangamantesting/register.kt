package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.imageview.ShapeableImageView
import android.widget.ImageButton

class register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etNama               = view.findViewById<TextInputEditText>(R.id.etNama)
        val etNik                = view.findViewById<TextInputEditText>(R.id.etNik)
        val etEmail              = view.findViewById<TextInputEditText>(R.id.etEmailRegister)
        val etNoHp               = view.findViewById<TextInputEditText>(R.id.etNoHp)
        val etPassword           = view.findViewById<TextInputEditText>(R.id.etPasswordRegister)
        val etKonfirmasiPassword = view.findViewById<TextInputEditText>(R.id.etKonfirmasiPassword)
        val cbSyarat             = view.findViewById<CheckBox>(R.id.cbSyarat)
        val btnDaftar            = view.findViewById<MaterialButton>(R.id.btnDaftar)
        val tvKeLogin            = view.findViewById<TextView>(R.id.tvKeLogin)
        val btnBack              = view.findViewById<ImageButton>(R.id.btnBack)

        // Tombol Back → kembali ke Login
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // Link "Sudah punya akun?" → Login
        tvKeLogin.setOnClickListener {
            findNavController().navigateUp()
        }

        // Tombol Daftar → Form Data User
        btnDaftar.setOnClickListener {
            val nama     = etNama.text.toString().trim()
            val nik      = etNik.text.toString().trim()
            val email    = etEmail.text.toString().trim()
            val noHp     = etNoHp.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val konfirmasi = etKonfirmasiPassword.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"; return@setOnClickListener
            }
            if (nik.length != 16) {
                etNik.error = "NIK harus 16 digit"; return@setOnClickListener
            }
            if (email.isEmpty()) {
                etEmail.error = "Email tidak boleh kosong"; return@setOnClickListener
            }
            if (noHp.isEmpty()) {
                etNoHp.error = "Nomor HP tidak boleh kosong"; return@setOnClickListener
            }
            if (password.isEmpty()) {
                etPassword.error = "Kata sandi tidak boleh kosong"; return@setOnClickListener
            }
            if (password != konfirmasi) {
                etKonfirmasiPassword.error = "Kata sandi tidak cocok"; return@setOnClickListener
            }
            if (!cbSyarat.isChecked) {
                Toast.makeText(requireContext(), "Harap setujui syarat dan ketentuan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Daftarkan akun ke backend di sini
            Toast.makeText(requireContext(), "Pendaftaran berhasil!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_register_to_form_data_user)
        }
    }
}