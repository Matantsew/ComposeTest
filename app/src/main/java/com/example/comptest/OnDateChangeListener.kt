package com.example.comptest

import com.example.comptest.ui.MonthFragment

interface OnDateChangeListener {
    fun onChangeDate(fragmentWhereDateSelected: MonthFragment, changedYear: Int, changedMonth: Int, changedDayOfMonth: Int, selectedDayName: String)
}