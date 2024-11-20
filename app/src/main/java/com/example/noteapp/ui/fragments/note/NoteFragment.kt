package com.example.noteapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.utils.PreferenceHelper

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()

    }

    private fun setupListeners() = with(binding) {
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(requireContext())
        //btnSave.setOnClickListener{
            //var et = etText.text.toString()
            //txtMain.text = et
        //}
        //txtMain.text = sharedPreferences.text

        //.setOnClickListener{
            ///findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment, null,
                // {
                    //anim {
                        //enter = R.anim.slide_in_right
                        //exit = R.anim.slide_out_left
                    //}
                //}
           //)
        //}
    }
}