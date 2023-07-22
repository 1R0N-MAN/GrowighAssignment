package com.example.growighassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class OnBoardingPage1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_on_boarding_page1, container, false)

        val progressButton = view.findViewById<Button>(R.id.progressButton1)
        progressButton.setOnClickListener {
            (activity as OnBoardingActivity).onButtonClicked(progressButton)
        }

        val skipIntroButton = view.findViewById<Button>(R.id.skipIntroButton)
        skipIntroButton.setOnClickListener {
            (activity as OnBoardingActivity).onButtonClicked(skipIntroButton)
        }

        return view
    }
}