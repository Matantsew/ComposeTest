package com.example.comptest

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.comptest.databinding.DialogCustomDatePickerBinding
import com.example.comptest.ui.MonthFragment
import com.example.comptest.ui.MonthFragment.Companion.getNameOfMonth
import java.text.SimpleDateFormat
import java.util.*

class CustomDatePickerDialog(private val fragmentActivity: FragmentActivity, private val listener: DatePickerDialog.OnDateSetListener?,
                             year: Int, month: Int, dayOfMonth: Int)
    : AlertDialog(fragmentActivity), View.OnClickListener{

    private var calendar: Calendar = Calendar.getInstance()

    private lateinit var binding: DialogCustomDatePickerBinding

    init {
        calendar.set(year, month, dayOfMonth)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.monthsViewPager.adapter = CalendarViewPagerAdapter(fragmentActivity, calendar, listener, binding)
        binding.monthsViewPager.setCurrentItem(600, false) // TODO: add minDate attribute

        binding.okButton.setOnClickListener(this)
        binding.cancelButton.setOnClickListener(this)
        binding.buttonNavLeft.setOnClickListener(this)
        binding.buttonNavRight.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        val monthsViewPager = binding.monthsViewPager

        when(v.id){
            R.id.ok_button -> {
                val adapter = (monthsViewPager.adapter as CalendarViewPagerAdapter)

                val y = adapter.selectedYear
                val m = adapter.selectedMonth
                val d = adapter.selectedDayOfMonth

                Log.i("DATE_SELECTED", "Year: $y, Month: $m, Day: $d")
            }
            R.id.cancel_button -> {
                this.cancel()
            }
            R.id.button_nav_left -> {
                monthsViewPager.setCurrentItem(monthsViewPager.currentItem-1, true)
            }
            R.id.button_nav_right -> {
                monthsViewPager.setCurrentItem(monthsViewPager.currentItem+1, true)
            }

        }
    }

    class CalendarViewPagerAdapter(fragmentActivity: FragmentActivity, private val calendar: Calendar, private val listener: DatePickerDialog.OnDateSetListener?, private val dialogCustomDatePickerBinding: DialogCustomDatePickerBinding)
        : FragmentStateAdapter(fragmentActivity), MonthFragment.OnDateChangeListener {

        private val MIDDLE_OF_ALL_MONTHS = 600

        private val actualDateCheckCalendar = Calendar.getInstance()

        private var fragmentWhereDateSelected: MonthFragment? = null

        var selectedYear = actualDateCheckCalendar.get(Calendar.YEAR)
        var selectedMonth = actualDateCheckCalendar.get(Calendar.MONTH)
        var selectedDayOfMonth = actualDateCheckCalendar.get(Calendar.DAY_OF_MONTH)

        override fun getItemCount() = 12 * 100   // Count of all months

        override fun createFragment(position: Int): Fragment {

            val scrolledToPosition = MIDDLE_OF_ALL_MONTHS - position

            val monthToShowCalendar = setMonth(scrolledToPosition)

            val today = actualDateCheckCalendar.get(Calendar.DAY_OF_MONTH)

            val monthStartsAtDay = monthToShowCalendar.getFirstDayNameOfFirstWeek()
            val daysInMonth = monthToShowCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            val monthFragment = if (monthToShowCalendar.get(Calendar.YEAR) == actualDateCheckCalendar.get(Calendar.YEAR) &&     // Today selection
                monthToShowCalendar.get(Calendar.MONTH) == actualDateCheckCalendar.get(Calendar.MONTH)
                    ) MonthFragment(monthStartsAtDay, daysInMonth, today)
            else MonthFragment(monthStartsAtDay, daysInMonth)

            if(selectedYear == monthToShowCalendar.get(Calendar.YEAR)                                   // User date selection
                && selectedMonth == monthToShowCalendar.get(Calendar.MONTH)){
                    monthFragment.year = monthToShowCalendar.get(Calendar.YEAR)
                    monthFragment.month = monthToShowCalendar.get(Calendar.MONTH)
                    monthFragment.selectedDay = selectedDayOfMonth
            }
            else {
                monthFragment.year = monthToShowCalendar.get(Calendar.YEAR)
                monthFragment.month = monthToShowCalendar.get(Calendar.MONTH)
                monthFragment.selectedDay = 0
            }

            monthFragment.setOnDateChangeListener(this)

            return monthFragment
        }

        private fun Calendar.getFirstDayNameOfFirstWeek(): Int {
            val simpleDateFormat = SimpleDateFormat("u")

            val checkCalendar = Calendar.getInstance()
            checkCalendar.set(this.get(Calendar.YEAR), this.get(Calendar.MONTH), 1)

            return simpleDateFormat.format(checkCalendar.time).toInt()
        }

        private fun setMonth(diff: Int): Calendar{

            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            val day = 1

            when {
                month - diff == 12 -> {
                    month = Calendar.JANUARY
                    year++
                }
                month - diff == -1 -> {
                    month = Calendar.DECEMBER
                    year--
                }
                else -> {
                    month -= diff
                }
            }

            val setMonthCalendar = Calendar.getInstance()
            setMonthCalendar.set(year, month, day)

            return setMonthCalendar
        }

        override fun onChangeDate(changedYear: Int, changedMonth: Int, changedDayOfMonth: Int, selectedDayName: String) {
            selectedYear = changedYear
            selectedMonth = changedMonth
            selectedDayOfMonth = changedDayOfMonth

            dialogCustomDatePickerBinding.textViewSelectedMonthYear.text = (getNameOfMonth(selectedMonth) + ", " + selectedYear)
            dialogCustomDatePickerBinding.selectedDayNameDateTextView.text = ("$selectedDayName, $selectedDayOfMonth")
        }

        override fun onExchangeDateFragments(fragmentWhereDateSelected: MonthFragment) {

            if(this.fragmentWhereDateSelected != fragmentWhereDateSelected) {
                this.fragmentWhereDateSelected?.invalidatePreviousSelectedDayButton()
                this.fragmentWhereDateSelected = fragmentWhereDateSelected
            }
        }
    }
}