package com.sytyy.com.jetscomview.jetscomfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.sytyy.com.R
import com.sytyy.com.databinding.FragmentJetscomLoadingBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class JetscomLoadingFragment : Fragment(R.layout.fragment_jetscom_loading) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentJetscomLoadingBinding.bind(view)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                delay(Random.nextLong(2000, 5000))
                findNavController().navigate(R.id.jetscomMenuFragment)
            }
        }
    }


}