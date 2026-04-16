package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class profil_pengguna : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profil_pengguna, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEdit   = view.findViewById<MaterialButton>(R.id.btnEdit)
        val btnLogout = view.findViewById<MaterialButton>(R.id.btnLogout)

        // Tombol Edit Profil (placeholder – bisa dihubungkan ke form edit nanti)
        btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur edit profil segera hadir!", Toast.LENGTH_SHORT).show()
        }

        // Tombol Logout → kembali ke Login dan hapus back stack
        btnLogout.setOnClickListener {
            findNavController().navigate(
                R.id.login,
                null,
                androidx.navigation.NavOptions.Builder()
                    .setPopUpTo(R.id.nav_menu, true)
                    .build()
            )
        }
    }
}