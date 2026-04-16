package com.ubermensch.ruangamantesting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ubermensch.ruangamantesting.databinding.FragmentProfilPenggunaBinding

class profil_pengguna : Fragment() {

    private var _binding: FragmentProfilPenggunaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilPenggunaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data dari SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val sharedName = sharedPref.getString("user_nama", "Pengguna")
        val sharedEmail = sharedPref.getString("user_email", "email@contoh.com")

        // Tampilkan data menggunakan binding agar singkat
        with(binding) {
            tvNama.text = sharedName
            tvEmail.text = sharedEmail

            // Tombol Edit Profil
            btnEdit.setOnClickListener {
                Toast.makeText(requireContext(), "Fitur edit profil segera hadir!", Toast.LENGTH_SHORT).show()
            }

            // Tombol Logout
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}