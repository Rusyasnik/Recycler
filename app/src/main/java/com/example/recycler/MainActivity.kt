package com.example.recycler

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.recycler.databinding.ActivityMainBinding
import com.example.recycler.fragments.ListFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    private val handler = Handler()
    val timeout = kotlinx.coroutines.Runnable {
        try {
            MAIN.navController.navigate(R.id.action_listFragment_to_FirstFragment)
        } catch (_: Exception) {}
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        MAIN = this
    }

    fun stopHandler() {
        handler.removeCallbacks(timeout)
    }

    fun startHandler() {
        handler.postDelayed(timeout, 60*1000)
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        stopHandler()
        startHandler()
    }
}