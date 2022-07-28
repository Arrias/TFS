package com.example.mainactivity.mainpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mainactivity.databinding.MainpageFragmentBinding
import com.example.mainactivity.db.Entry
import java.time.LocalDateTime
import java.util.*

class MainPageFragment : Fragment() {
    private var _binding: MainpageFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var model: MainPageModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.applicationContext?.let {
            model = MainPageModel(it)
        }
        _binding = MainpageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.addFailureButton?.setOnClickListener {
            val newEntry = Entry("hello world", Date())
            model?.saveEntryToDb(newEntry)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}