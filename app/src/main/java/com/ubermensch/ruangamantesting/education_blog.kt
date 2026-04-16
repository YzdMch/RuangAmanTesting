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

class education_blog : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_education_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvEducation = view.findViewById<RecyclerView>(R.id.rvEducationBlog)
        rvEducation.layoutManager = LinearLayoutManager(requireContext())

        val articles = EducationData.getArticles()
        rvEducation.adapter = EducationAdapter(articles) { article ->
            val bundle = Bundle().apply {
                putString("title", article.title)
                putString("content", article.content)
                putString("author", article.author)
                putString("date", article.date)
            }
            findNavController().navigate(
                R.id.action_education_blog_to_education_blog_detail,
                bundle
            )
        }
    }
}