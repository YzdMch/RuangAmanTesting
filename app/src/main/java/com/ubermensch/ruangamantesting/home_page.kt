package com.ubermensch.ruangamantesting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubermensch.ruangamantesting.databinding.FragmentHomePageBinding

class home_page : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val sharedName = sharedPref.getString("user_nama", "User")

        with(binding) {
            tvUserName.text = sharedName

            // Card Lapor Perundungan → Form Pelaporan
            cardLaporBully.setOnClickListener {
                findNavController().navigate(R.id.action_home_page_to_form_pelaporan)
            }

            // "Lihat Semua" Edukasi → Education Blog
            tvSeeAll.setOnClickListener {
                findNavController().navigate(R.id.action_home_page_to_education_blog)
            }

            // Icon Profil kecil → Profil Pengguna
            ivProfileSmall.setOnClickListener {
                findNavController().navigate(R.id.action_home_page_to_profil_pengguna)
            }

            // RecyclerView preview edukasi
            rvEducationPreview.layoutManager = LinearLayoutManager(requireContext())
            val previewItems = EducationData.getArticles().take(3)
            rvEducationPreview.adapter = EducationAdapter(previewItems) { article ->
                val bundle = Bundle().apply {
                    putString("title", article.title)
                    putString("content", article.content)
                    putString("author", article.author)
                    putString("date", article.date)
                }
                findNavController().navigate(
                    R.id.action_home_page_to_education_blog_detail,
                    bundle
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}