package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapters.OnBoardAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        binding.viewpager2.adapter = OnBoardAdapter(this)
        binding.dotsIndicator.attachTo(binding.viewpager2)
    }

    private fun setupListeners() = with(binding.viewpager2) {
        registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2){
                    binding.txtSkip.visibility = View.INVISIBLE
                }else{
                    binding.txtSkip.visibility = View.VISIBLE
                    binding.txtSkip.setOnClickListener {
                        if(currentItem < 3){
                            setCurrentItem(currentItem + 2, true)
                        }
                    }
                }
            }
        })
    }
}