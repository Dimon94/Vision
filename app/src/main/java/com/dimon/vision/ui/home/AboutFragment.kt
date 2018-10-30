package com.dimon.vision.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dimon.vision.R
import dagger.android.DaggerFragment

class AboutFragment : DaggerFragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

}