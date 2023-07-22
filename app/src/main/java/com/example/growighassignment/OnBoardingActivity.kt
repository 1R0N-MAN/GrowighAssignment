package com.example.growighassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class OnBoardingActivity : AppCompatActivity() {

    private val isNewUserSHPR = "IS_NEW_USER_SHPR"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        // check if the user has opened the app more than once
        checkIsNewUser()

        // Load the first on boarding page when the activity is created
        if (savedInstanceState == null){
            loadFragment(OnBoardingPage1())
        }
    }

    private fun checkIsNewUser() {
        val sharedPreferences = getSharedPreferences("ON_BOARDING_SHARED_PREFERENCES", MODE_PRIVATE)

        val isNewUser = sharedPreferences.getBoolean(isNewUserSHPR, true)

        if(isNewUser){
            sharedPreferences.edit()
                .putBoolean(isNewUserSHPR, false)
                .apply()
        } else {
            openHomeActivity()
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    fun onButtonClicked(view: View){
        when (view.id){
            R.id.progressButton1 -> loadFragment(OnBoardingPage2())
            R.id.progressButton2 -> loadFragment(OnBoardingPage3())
            R.id.readyButton -> openHomeActivity()
            R.id.skipIntroButton -> openHomeActivity()
        }
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}