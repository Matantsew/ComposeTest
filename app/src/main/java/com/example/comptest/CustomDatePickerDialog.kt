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

        val monthStartsAtDay = calendar.firstDayOfFirstWeek()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        binding.weeksViewPager.adapter = CalendarViewPagerAdapter(fragmentActivity, monthStartsAtDay, daysInMonth)
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
        TODO("Not yet implemented")
    }

    private fun Calendar.firstDayOfFirstWeek(): Int {
        val simpleDateFormat = SimpleDateFormat("u")

        return simpleDateFormat.format(this.time).toInt()
    }

    class CalendarViewPagerAdapter(fragmentActivity: FragmentActivity, private val dayOfWeekStarts: Int, private val daysInMonthCount: Int,
    ) : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount() = 7

        override fun createFragment(position: Int): Fragment {

            val weeksFragment = WeeksViewFragment(position+1, 31, 3)

            return weeksFragment
        }

    }

}