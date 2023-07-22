package com.example.growighassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class OnBoardingPage3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding_page3, container, false)

        val readyButton = view.findViewById<Button>(R.id.readyButton)
        readyButton.setOnClickListener {
            (activity as OnBoardingActivity).onButtonClicked(readyButton)
        }

        val skipIntroButton = view.findViewById<Button>(R.id.skipIntroButton)
        skipIntroButton.setOnClickListener {
            (activity as OnBoardingActivity).onButtonClicked(skipIntroButton)
        }

        return view
    }
}