package com.example.noteapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.data.models.NoteModel
import com.example.noteapp.databinding.FragmentNoteDetailBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding

    private val noteDate: String = SimpleDateFormat("dd MMMM", Locale.getDefault()).format(Date())
    private val noteTime: String = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        initialize()
    }

    private fun setupListeners() = with(binding) {


        btnSave.setOnClickListener{
            val etTitle = etTitle.text.toString().trim()
            val etDescription = etDescription.text.toString().trim()

            App.appDatabase?.noteDao()?.insertNote(NoteModel(etTitle, etDescription, noteTime, noteDate))
            findNavController().navigateUp()
        }
        toolbarDetail.setNavigationOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun initialize() = with(binding) {
        tvDate.apply {
            tvDate.text = noteDate
        }
        tvTime.apply {
            tvTime.text = noteTime
        }
        if(etTitle.text.toString().isEmpty() && etDescription.text.toString().isEmpty()){
            btnSave.visibility = View.GONE
        }
        else{
            btnSave.visibility = View.VISIBLE
        }
    }

}