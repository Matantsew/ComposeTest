package com.example.comptest

import androidx.compose.runtime.mutableStateListOf

object SampleData {

    val products = mutableStateListOf<Product>().apply {
        add(Product("Brot", R.drawable.sliced_bread))
        add(Product("Weissbrot", R.drawable.bread))
        add(Product("Nussbrot", null))
        add(Product("Kornbrot", null))
        add(Product("Nusskornbrot", null))
        add(Product("Neu brot", null))
        add(Product("Brot", R.drawable.bread))
        add(Product("Neubrot", null))
        add(Product("Brot", R.drawable.bread))
        add(Product("Brot", null))
    }

    val categories = mutableStateListOf<Category>().apply {
        add(Category("Spezialbrot", R.drawable.sliced_bread))
        add(Category("Grossbrot", R.drawable.bread))
        add(Category("Fruits", null))
        /*add(Category("Vegetables", null))
        add(Category("Zopf", null))*/
    }
}