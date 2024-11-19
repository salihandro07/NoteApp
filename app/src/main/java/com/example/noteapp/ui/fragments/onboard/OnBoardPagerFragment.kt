package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.databinding.FragmentOnBoardPagerBinding


class OnBoardPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentOnBoardPagerBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                txtTitle.text = "Удобство"
                txtBody.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
                lottieAnimationView.setAnimation(R.raw.onboard1)
                btnStart.visibility = View.INVISIBLE

            }
            1 -> {
                txtTitle.text = "Организация"
                txtBody.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                lottieAnimationView.setAnimation(R.raw.onboard2)
                btnStart.visibility = View.INVISIBLE
            }
            2 -> {
                txtTitle.text = "Синхронизация"
                txtBody.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
                lottieAnimationView.setAnimation(R.raw.onboard3)
                btnStart.visibility = View.VISIBLE
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}