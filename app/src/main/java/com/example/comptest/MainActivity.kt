package com.example.comptest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testViewModel: TestViewModel by viewModels()

        val menuFragment = MenuFragment()
        val categoryFragment = CategoryFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.menu_container, menuFragment)
            .commit()
    }
}