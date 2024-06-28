package com.example.curandmon4homwor2.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.curandmon4homwor2.ui.fragment.omBoard.OnBoardPagingFragment
import com.example.curandmon4homwor2.ui.fragment.omBoard.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }

    }

}