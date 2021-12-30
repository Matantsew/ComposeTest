package com.example.comptest

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.comptest.databinding.DialogCustomDatePickerBinding
import com.example.comptest.ui.WeeksViewFragment
import java.text.SimpleDateFormat
import java.util.*

class CustomDatePickerDialog(context: Context, listener: DatePickerDialog.OnDateSetListener?, private val fragmentActivity: FragmentActivity,
                             private val year: Int, private val month: Int, private val dayOfMonth: Int)
    : AlertDialog(context), DialogInterface.OnClickListener, CalendarView.OnDateChangeListener{

    private var calendar: Calendar = Calendar.getInstance()

    private lateinit var binding: DialogCustomDatePickerBinding

    init {
        calendar.set(year, month, dayOfMonth)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weeksViewPager.adapter = CalendarViewPagerAdapter(fragmentActivity, calendar)
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    class CalendarViewPagerAdapter(fragmentActivity: FragmentActivity, private val calendar: Calendar) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount() = 12 * 100

        override fun createFragment(position: Int): Fragment {

            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val monthStartsAtDay = calendar.getFirstDayNameOfFirstWeek()
            val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            val weeksFragment = if(calendar.get(Calendar.MONTH) == getActualMonth())
                WeeksViewFragment(monthStartsAtDay, daysInMonth, dayOfMonth)
            else WeeksViewFragment(monthStartsAtDay, daysInMonth)

            return weeksFragment
        }

        private fun Calendar.getFirstDayNameOfFirstWeek(): Int {
            val simpleDateFormat = SimpleDateFormat("u")

            val checkCalendar = Calendar.getInstance()
            checkCalendar.set(this.get(Calendar.YEAR), this.get(Calendar.MONTH), 1)

            return simpleDateFormat.format(checkCalendar.time).toInt()
        }

        private fun getActualMonth(): Int{
            return Calendar.getInstance().get(Calendar.MONTH)
        }

    }

}