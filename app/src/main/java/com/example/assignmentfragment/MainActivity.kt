package com.example.assignmentfragment

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assignmentfragment.ui.login.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomView = findViewById<BottomNavigationView>(R.id.navigationView)
        bottomView.selectedItemId = R.id.home_item

        replaceWithFragment(Home_Fragment())

        bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_item -> replaceWithFragment(Home_Fragment())
                R.id.search_item -> replaceWithFragment(Search_Fragment())
                R.id.cart -> replaceWithFragment(Cart_Fragment())
                R.id.categories -> replaceWithFragment(Categories_Fragment())
                R.id.profile -> replaceWithFragment(LoginFragment())
                else -> {
                    Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}