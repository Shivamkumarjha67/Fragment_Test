package com.example.fragment_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var fv : FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fv = findViewById(R.id.fv)
        val navgView : BottomNavigationView = findViewById(R.id.btmNag)
        openFragment(MyFirstFragment())

        navgView.setOnNavigationItemSelectedListener {
            val id = it.itemId
            when(id) {
                R.id.home -> {
                    openFragment(MyFirstFragment())
                }

                R.id.explore -> {
                    openFragment(MySecondFragment())
                }

                R.id.profile -> {
                    openFragment(MyThirdFragment())
                }
            }

            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun openFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fv, fragment)
            .commit()
    }


}