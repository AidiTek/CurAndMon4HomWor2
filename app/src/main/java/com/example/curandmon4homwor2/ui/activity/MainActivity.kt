package com.example.curandmon4homwor2.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.curandmon4homwor2.R
import com.example.curandmon4homwor2.databinding.ActivityMainBinding
import com.example.curandmon4homwor2.utills.SheredPreference

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferences = SheredPreference()
        sharedPreferences.unit(this)

        val isOnboardingCompleted = sharedPreferences.isBoard
        val navController = findNavController(R.id.fragment)

        val currentTime = System.currentTimeMillis()
        val lastLounchTime = sharedPreferences.lastLounchTime

        if (lastLounchTime == 0L || lastLounchTime > currentTime) {
            sharedPreferences.clear()
        }

        if (isOnboardingCompleted) {
            navController.navigate(R.id.noteFragment)
        } else {
            navController.navigate(R.id.onBoardFragment)
        }
    }
}