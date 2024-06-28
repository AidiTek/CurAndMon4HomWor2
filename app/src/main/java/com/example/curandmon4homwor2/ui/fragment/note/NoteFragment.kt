package com.example.curandmon4homwor2.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.curandmon4homwor2.R
import com.example.curandmon4homwor2.databinding.FragmentNoteBinding
import com.example.curandmon4homwor2.utills.SheredPreference

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListner()

    }

    private fun setUpListner() = with(binding) {

        val sheredPreference = SheredPreference()
        sheredPreference.unit(requireContext())

//        btnSave.setOnClickListener {
//
//            val et = etTitle.text.toString()
//            sheredPreference.title = et
//            tvSave.text = et
//        }
//
//        tvSave.text = sheredPreference.title
//
        imgAddNot.setOnClickListener {

            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment,null,)

        }
   }
}