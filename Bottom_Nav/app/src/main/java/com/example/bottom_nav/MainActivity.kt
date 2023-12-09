package com.example.bottomnavigasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bottom_nav.AgendaFragment
import com.example.bottom_nav.DetailFragment
import com.example.bottom_nav.HomeFragment
import com.example.bottom_nav.ProfileFragment
import com.example.bottom_nav.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById(R.id.bottom_navigasi)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.beranda -> selectedFragment = HomeFragment()
                R.id.agenda -> selectedFragment = AgendaFragment()
                R.id.profile -> selectedFragment = ProfileFragment()
                R.id.detail -> selectedFragment = DetailFragment()
            }

            if (selectedFragment != null) {
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.framelayout, selectedFragment)
                    .commit()
            }

            true
        }
    }
}