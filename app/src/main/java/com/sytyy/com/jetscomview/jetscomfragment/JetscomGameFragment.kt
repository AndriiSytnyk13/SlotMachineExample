package com.sytyy.com.jetscomview.jetscomfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.sytyy.com.R
import com.sytyy.com.databinding.FragmentJetscomGameBinding
import com.sytyy.com.jetscomviewmodel.JetscomGameViewModel
import kotlinx.coroutines.launch

class JetscomGameFragment : Fragment(R.layout.fragment_jetscom_game) {

    private val jetscomViewModel: JetscomGameViewModel by viewModels()
    private lateinit var jetscomGameBinding: FragmentJetscomGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jetscomGameBinding = FragmentJetscomGameBinding.bind(view)
        jetscomGameBinding.jetscomTable.setOnClickListener {
            findNavController().navigate(R.id.jetscomTableFragment)
            jetscomViewModel.jetscomStopSpinWhenNavigateToPayTable()
        }
        collectJetscomData()
    }

    private fun collectJetscomData() {
        jetscomGameBinding.jetscomViewModel = jetscomViewModel
        jetscomGameBinding.lifecycleOwner = viewLifecycleOwner
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    jetscomViewModel.jetscomSlot1Pic.collect {
                        jetscomGameBinding.jetscomSlot1.setImageResource(it)
                    }
                }
                launch {
                    jetscomViewModel.jetscomSlot2Pic.collect {
                        jetscomGameBinding.jetscomSlot2.setImageResource(it)
                    }
                }
                launch {
                    jetscomViewModel.jetscomSlot3Pic.collect {
                        jetscomGameBinding.jetscomSlot3.setImageResource(it)
                    }
                }
                launch {
                    jetscomViewModel.jetscomSpinVisibility.collect {
                        jetscomGameBinding.jetscomSpin.visibility = it
                    }
                }
            }
        }
    }


}