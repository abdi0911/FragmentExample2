package com.example.fragmentexample2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexample2.databinding.BookTitlesBinding

class BookTitle : Fragment(), View.OnClickListener {
    private var _binding: BookTitlesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookTitlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.learnAp.setOnClickListener(this)
        binding.learnApWithKotlin.setOnClickListener(this)
        binding.minimumAp.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val index = when (v.id) {
            R.id.learn_ap -> 0
            R.id.learn_ap_with_kotlin -> 1
            R.id.minimum_ap -> 2
            else -> -1 // Default case if needed
        }

        // Notify the activity if a valid index is found
        if (index != -1) {
            (activity as? Coordinator)?.onBookChanged(index)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}