package com.sytyy.com.jetscomview.jetscomfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sytyy.com.R
import com.sytyy.com.databinding.FragmentJetscomTableBinding
import com.sytyy.com.jetscomview.adapter.JetscomPayTableAdapter

class JetscomTableFragment : Fragment(R.layout.fragment_jetscom_table) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentJetscomTableBinding.bind(view).apply {
            payTableRecyclerview.adapter = JetscomPayTableAdapter()
        }
    }

}