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

class form_data_user : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_data_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etNama     = view.findViewById<TextInputEditText>(R.id.etNama)
        val etNik      = view.findViewById<TextInputEditText>(R.id.etNik)
        val etTelepon  = view.findViewById<TextInputEditText>(R.id.etTelepon)
        val btnSimpan  = view.findViewById<MaterialButton>(R.id.btnSimpan)

        // Tombol Simpan Data → Home Page
        btnSimpan.setOnClickListener {
            val nama    = etNama.text.toString().trim()
            val nik      = etNik.text.toString().trim()
            val telepon = etTelepon.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"; return@setOnClickListener
            }
            if (nik.length != 16) {
                etNik.error = "NIK harus 16 digit"; return@setOnClickListener
            }
            if (telepon.isEmpty()) {
                etTelepon.error = "Nomor WhatsApp tidak boleh kosong"; return@setOnClickListener
            }

            // TODO: Simpan data user ke backend/lokal di sini
            Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_form_data_user_to_home_page)
        }
    }
}