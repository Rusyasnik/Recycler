package com.example.recycler.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recycler.MAIN
import com.example.recycler.R
import com.example.recycler.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.screensaverBackground.setOnClickListener() {
            MAIN.navController.navigate(R.id.action_FirstFragment_to_listFragment)
        }
        binding.screensaverHandPicture.setOnClickListener {
            MAIN.navController.navigate(R.id.action_FirstFragment_to_listFragment)
        }
    }
}