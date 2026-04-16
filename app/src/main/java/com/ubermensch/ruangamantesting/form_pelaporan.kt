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

class form_pelaporan : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_pelaporan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etKelas       = view.findViewById<TextInputEditText>(R.id.et_kelas)
        val etPhone       = view.findViewById<TextInputEditText>(R.id.et_phone)
        val etLokasi      = view.findViewById<TextInputEditText>(R.id.et_lokasi)
        val etDeskripsi   = view.findViewById<TextInputEditText>(R.id.et_deskripsi)
        val etRekomendasi = view.findViewById<TextInputEditText>(R.id.et_rekomendasi)
        val btnSimpan     = view.findViewById<MaterialButton>(R.id.btn_simpan)

        // Tombol Kirim Laporan → kembali ke Home (setelah berhasil)
        btnSimpan.setOnClickListener {
            val kelas     = etKelas.text.toString().trim()
            val phone     = etPhone.text.toString().trim()
            val lokasi    = etLokasi.text.toString().trim()
            val deskripsi = etDeskripsi.text.toString().trim()

            if (kelas.isEmpty()) {
                etKelas.error = "Kelas/jabatan tidak boleh kosong"; return@setOnClickListener
            }
            if (phone.isEmpty()) {
                etPhone.error = "Nomor WhatsApp tidak boleh kosong"; return@setOnClickListener
            }
            if (lokasi.isEmpty()) {
                etLokasi.error = "Lokasi kejadian tidak boleh kosong"; return@setOnClickListener
            }
            if (deskripsi.isEmpty()) {
                etDeskripsi.error = "Deskripsi kejadian tidak boleh kosong"; return@setOnClickListener
            }

            // TODO: Kirim laporan ke backend di sini
            Toast.makeText(requireContext(), "Laporan berhasil dikirim!", Toast.LENGTH_LONG).show()
            findNavController().navigateUp()
        }
    }
}