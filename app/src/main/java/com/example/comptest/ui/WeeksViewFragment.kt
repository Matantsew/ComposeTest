package com.example.comptest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comptest.R
import com.example.comptest.databinding.WeeksViewBinding

class WeeksViewFragment(private val dayOfWeekStarts: Int, private val daysInMonthCount: Int, private val todayDayNumber: Int? = null) : Fragment(){

    private lateinit var binding: WeeksViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = WeeksViewBinding.inflate(layoutInflater)

        renderWeeks()

        return binding.root
    }

    private fun renderWeeks(){
        (0 until daysInMonthCount).forEach{
            val calendarDay = binding.weeksLayout.findViewById<CalendarSelectableDayButton> (calendarDays[dayOfWeekStarts-1 + it])
            calendarDay.visibility = View.VISIBLE
            calendarDay.dateNumber = it + 1
            if(it + 1 == todayDayNumber)calendarDay.actualDate = true
        }
    }

    private companion object{
        private val calendarDays = arrayOf(
            R.id.w_1_d_1, R.id.w_1_d_2, R.id.w_1_d_3, R.id.w_1_d_4, R.id.w_1_d_5, R.id.w_1_d_6, R.id.w_1_d_7,
            R.id.w_2_d_1, R.id.w_2_d_2, R.id.w_2_d_3, R.id.w_2_d_4, R.id.w_2_d_5, R.id.w_2_d_6, R.id.w_2_d_7,
            R.id.w_3_d_1, R.id.w_3_d_2, R.id.w_3_d_3, R.id.w_3_d_4, R.id.w_3_d_5, R.id.w_3_d_6, R.id.w_3_d_7,
            R.id.w_4_d_1, R.id.w_4_d_2, R.id.w_4_d_3, R.id.w_4_d_4, R.id.w_4_d_5, R.id.w_4_d_6, R.id.w_4_d_7,
            R.id.w_5_d_1, R.id.w_5_d_2, R.id.w_5_d_3, R.id.w_5_d_4, R.id.w_5_d_5, R.id.w_5_d_6, R.id.w_5_d_7,
            R.id.w_6_d_1, R.id.w_6_d_2, R.id.w_6_d_3, R.id.w_6_d_4, R.id.w_6_d_5, R.id.w_6_d_6, R.id.w_6_d_7
        )
    }
}