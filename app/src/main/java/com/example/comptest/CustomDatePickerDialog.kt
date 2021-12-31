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
        binding.weeksViewPager.setCurrentItem(600, false)
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    class CalendarViewPagerAdapter(fragmentActivity: FragmentActivity, private val calendar: Calendar) : FragmentStateAdapter(fragmentActivity) {

        private val MIDDLE_COUNT_ITEMS = 600

        private val actualDate = Calendar.getInstance()

        override fun getItemCount() = 12 * 100

        override fun createFragment(position: Int): Fragment {

            val scrolledToPosition = MIDDLE_COUNT_ITEMS - position

            val monthToShow = setMonth(scrolledToPosition)

            val today = actualDate.get(Calendar.DAY_OF_MONTH)

            val monthStartsAtDay = monthToShow.getFirstDayNameOfFirstWeek()
            val daysInMonth = monthToShow.getActualMaximum(Calendar.DAY_OF_MONTH)

            return if (monthToShow.get(Calendar.YEAR) == actualDate.get(Calendar.YEAR) &&
                monthToShow.get(Calendar.MONTH) == actualDate.get(Calendar.MONTH) &&
                monthToShow.get(Calendar.DAY_OF_MONTH) == actualDate.get(Calendar.DAY_OF_MONTH)
                    ) WeeksViewFragment(monthStartsAtDay, daysInMonth, today)
            else WeeksViewFragment(monthStartsAtDay, daysInMonth)
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

            if(month - diff == 12){
                month = Calendar.JANUARY
                year++
            }
            else if(month - diff == -1){
                month = Calendar.DECEMBER
                year--
            }
            else {
                month -= diff
            }

            val differedCalendar = Calendar.getInstance()
            differedCalendar.set(year, month, day)

            return differedCalendar
        }

    }

}