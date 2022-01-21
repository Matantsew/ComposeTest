package com.example.comptest

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.FragmentActivity
import java.util.*

class MainActivity : FragmentActivity(), DatePickerDialog.OnDateSetListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_test).setOnClickListener {

            val calendar = Calendar.getInstance()
            val dialog = CustomDatePickerDialog(
                this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
/*
            val dialog = DatePickerDialog(              // Material DatePicker (Standard)
                this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )*/


            val minDateCalendar = Calendar.getInstance()
            minDateCalendar.set(2022, 0, 5)

            //dialog.minDate = minDateCalendar.timeInMillis
            dialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Log.i("DATE_SET", "Year: $year, month: $month, dayOfMonth: $dayOfMonth")
    }
}