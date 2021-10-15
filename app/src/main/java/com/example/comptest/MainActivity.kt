package com.example.comptest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testViewModel: TestViewModel by viewModels()

        val menuFragment = HomeFragment()
        val categoryFragment = CategoryFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.top_info_container, menuFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.categories_container, categoryFragment)
            .commit()
    }
}