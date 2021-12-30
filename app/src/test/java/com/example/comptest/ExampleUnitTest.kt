package com.example.comptest

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val calendar = Calendar.getInstance()
        val currentMonth = calendar.get(Calendar.MONTH)
        calendar.set(2021, currentMonth, 1)
        val sdf = SimpleDateFormat("u")
        val firstDayName = sdf.format(calendar.time).toInt()

        assertEquals(3, firstDayName)
    }
}