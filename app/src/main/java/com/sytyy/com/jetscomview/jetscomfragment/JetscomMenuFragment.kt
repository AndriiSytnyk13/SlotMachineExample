package com.sytyy.com.jetscomview.jetscomfragment

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sytyy.com.R
import com.sytyy.com.databinding.FragmentJetscomMenuBinding
import com.sytyy.com.service.MusicService


class JetscomMenuFragment : Fragment(R.layout.fragment_jetscom_menu) {

    private lateinit var jetscomMenuBinding: FragmentJetscomMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jetscomMenuBinding = FragmentJetscomMenuBinding.bind(view)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            finishJetscomApp()
        }
        jetscomMenuBinding.jetscomQuit.setOnClickListener {
            finishJetscomApp()
        }
        jetscomMenuBinding.jetscomPlay.setOnClickListener {
            findNavController().navigate(R.id.jetscomGameFragment)
        }

    }

    private fun finishJetscomApp() {
        requireActivity().finishAffinity()
    }

}