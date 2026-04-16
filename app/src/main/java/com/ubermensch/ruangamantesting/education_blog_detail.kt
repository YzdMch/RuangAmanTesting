package com.ubermensch.ruangamantesting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class education_blog_detail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education_blog_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle   = view.findViewById<TextView>(R.id.tvDetailTitle)
        val tvAuthor  = view.findViewById<TextView>(R.id.tvDetailAuthor)
        val tvDate    = view.findViewById<TextView>(R.id.tvDetailDate)
        val tvContent = view.findViewById<TextView>(R.id.tvDetailContent)
        val btnBack   = view.findViewById<ImageButton>(R.id.btnBackDetail)

        // Ambil data artikel dari arguments (Bundle)
        arguments?.let { args ->
            tvTitle.text   = args.getString("title", "Judul Artikel")
            tvAuthor.text  = args.getString("author", "Admin")
            tvDate.text    = args.getString("date", "")
            tvContent.text = args.getString("content", "Konten artikel...")
        }

        // Tombol Back → kembali ke Education Blog
        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}