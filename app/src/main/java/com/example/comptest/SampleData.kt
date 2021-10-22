package com.example.comptest

import androidx.compose.runtime.mutableStateListOf

object SampleData {

    val products = mutableStateListOf<Product>().apply {
        add(Product("Brot 1", R.drawable.sliced_bread))
        add(Product("Weissbrot 2", R.drawable.bread))
        add(Product("Nussbrot 3", null))
        add(Product("Kornbrot 4", null))
        add(Product("Nusskornbrot 5", null))
        add(Product("Neu brot 6", null))
        add(Product("Brot 7", R.drawable.bread))
        add(Product("Neubrot 8", null))
        add(Product("Brot 9", R.drawable.bread))
        add(Product("Brot 10", null))
        add(Product("Brot 11", null))
        add(Product("Brot 12", null))
    }

    val categories = mutableStateListOf<Category>().apply {
        add(Category("Spezialbrot", R.drawable.sliced_bread))
        add(Category("Grossbrot", R.drawable.bread))
        add(Category("Fruits", null))
        /*add(Category("Vegetables", null))
        add(Category("Zopf", null))*/
    }
}