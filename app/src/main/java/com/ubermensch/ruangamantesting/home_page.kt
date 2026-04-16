package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView

class home_page : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Card Lapor Perundungan → Form Pelaporan
        val cardLaporBully = view.findViewById<MaterialCardView>(R.id.card_lapor_bully)
        cardLaporBully.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_to_form_pelaporan)
        }

        // "Lihat Semua" Edukasi → Education Blog
        val tvSeeAll = view.findViewById<TextView>(R.id.tv_see_all)
        tvSeeAll.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_to_education_blog)
        }

        // Icon Profil kecil → Profil Pengguna
        val ivProfileSmall = view.findViewById<ShapeableImageView>(R.id.iv_profile_small)
        ivProfileSmall.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_to_profil_pengguna)
        }

        // RecyclerView preview edukasi (preview 3 item, klik item → education blog)
        val rvPreview = view.findViewById<RecyclerView>(R.id.rv_education_preview)
        rvPreview.layoutManager = LinearLayoutManager(requireContext())
        val previewItems = EducationData.getArticles().take(3)
        rvPreview.adapter = EducationAdapter(previewItems) { article ->
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