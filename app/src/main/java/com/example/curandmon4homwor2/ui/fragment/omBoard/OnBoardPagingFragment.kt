package com.example.curandmon4homwor2.ui.fragment.omBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RawRes
import com.airbnb.lottie.LottieAnimationView
import com.example.curandmon4homwor2.R
import com.example.curandmon4homwor2.databinding.FragmentOnBoardPagingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()

    }

    private fun initialize() = with(binding) {

        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {

            0 -> {
                val animation = R.raw.first_animation
                tvTxt.text = "Очень удобный функционал"
                lottiAnimation.setAnimation(animation)

            }

            1 -> {
                val animation = R.raw.second_animation
                tvTxt.text = "Быстрый, качественный продукт"
                lottiAnimation.setAnimation(animation)

            }

            2 -> {
                val animation = R.raw.third_animation
                tvTxt.text = "Куча функций и интересных фишек"
                lottiAnimation.setAnimation(animation)


            }

        }

    }

    companion object {

        const val ARG_ONBOARD_POSITION = "onBoard"

    }
}