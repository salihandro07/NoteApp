package com.example.noteapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.data.models.NoteModel
import com.example.noteapp.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_note_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_noteDetailFragment_to_noteFragment)
        }
        btnSave.setOnClickListener {
            val tvDate = tvDate.text.toString()
            val tvTime = tvTime.text.toString()
            val etTitle = etTitle.toString()
            val etDescription = etDescription.text.toString()
            App.appDatabase?.noteDao()?.insertNote(NoteModel (etDescription, etTitle, tvDate, tvTime))
            findNavController().navigateUp()
        }
    }
}