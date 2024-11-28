package com.example.noteapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.ui.adapters.NoteAdapter

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter(false)
    private var isLinearLayout = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        initialize()
        getData()
    }

    private fun setupListeners() = with(binding) {
        btnAction.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }

        btnChangeLayout.setOnClickListener {
            if(isLinearLayout){
                binding.rvNote.layoutManager = GridLayoutManager(requireContext(), 2)
                noteAdapter.setLayoutType(true)
                btnChangeLayout.setBackgroundResource(R.drawable.baseline_format_list_bulleted_24)
            }else{
                binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
                noteAdapter.setLayoutType(false)
                btnChangeLayout.setBackgroundResource(R.drawable.baseline_dashboard_24)
            }
            isLinearLayout = !isLinearLayout
        }
    }

    private fun initialize() {
        binding.rvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun getData() {
        App.appDatabase?.noteDao()?.getAll()?.observe(viewLifecycleOwner){item ->
            noteAdapter.submitList(item)
        }
    }
}