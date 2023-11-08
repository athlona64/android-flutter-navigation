package com.example.android_native_spike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.flutter.embedding.android.FlutterFragment

class MainActivity : AppCompatActivity() {
    private val homeFragment: Fragment = HomeFragment()
    private val notificationsFragment: Fragment = NotificationsFragment()
    private val flutterFragment = FlutterFragment.createDefault()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity_layout)

        val navView: BottomNavigationView = findViewById(R.id.navigation)

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    openFragment(homeFragment)
                    true
                }
                R.id.navigation_dashboard -> {
                    openFlutterView()
                    true
                }
                R.id.navigation_notifications -> {
                    openFragment(notificationsFragment)
                    true
                }
                else -> false
            }
        }


        navView.setOnItemReselectedListener { item ->
            // Handle item reselection if necessary
        }

        openFragment(homeFragment)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

    private fun openFlutterView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, flutterFragment)
            .commit()
    }
}
