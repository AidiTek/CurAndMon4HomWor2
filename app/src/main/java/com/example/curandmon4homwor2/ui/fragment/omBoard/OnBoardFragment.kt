package com.example.curandmon4homwor2.ui.fragment.omBoard

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.curandmon4homwor2.R
import com.example.curandmon4homwor2.databinding.FragmentOnBoardBinding
import com.example.curandmon4homwor2.ui.adapter.OnBoardViewPagerAdapter
import com.example.curandmon4homwor2.utills.SheredPreference
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListner()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->

            val customView = LayoutInflater.from(binding.tabLayout.context)
                .inflate(R.layout.tab_item_icon, binding.tabLayout, false)

            val tabIcon = customView.findViewById<ImageView>(R.id.tab_icon)
            tabIcon.setImageResource(getTabIcon(position)) // метод для получения иконки в зависимости от позиции

            tab.customView = customView
        }.attach()
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.baseline_circle_24
            1 -> R.drawable.baseline_circle_24
            2 -> R.drawable.baseline_circle_24
            else -> R.id.tab_icon // Замените на вашу иконку по умолчанию или исходную
        }
    }

    private fun setupListner() = with(binding.viewPager2) {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                resetTabIcons()

                val selectedTab = binding.tabLayout.getTabAt(position)
                selectedTab?.customView?.findViewById<ImageView>(R.id.tab_icon)
                    ?.setColorFilter(ContextCompat.getColor(requireContext(), R.color.orange))

                val sheredPreference = SheredPreference()
                sheredPreference.unit(requireContext())

                if (position == 2) {
                    binding.tvStart.visibility = View.VISIBLE
                    binding.tvSkip.visibility = View.INVISIBLE
                } else {
                    binding.tvStart.visibility = View.INVISIBLE

                    binding.tvSkip.visibility = View.VISIBLE

                }
                binding.tvSkip.setOnClickListener {
                    setCurrentItem(currentItem + 2, true)

                }
                binding.tvStart.setOnClickListener {
                    sheredPreference.isBoard = true
                    findNavController().navigate(R.id.action_onBoardFragment_to_noteFragment)
                }

            }
        })

    }

    private fun resetTabIcons() {
        // Сброс всех иконок в исходный цвет (если нужно)
        for (i in 0 until binding.tabLayout.tabCount) {
            val tab = binding.tabLayout.getTabAt(i)
            tab?.customView?.findViewById<ImageView>(R.id.tab_icon)
                ?.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.grey
                    )
                )// замените R.color.original_color на ваш исходный цвет
        }
    }


}