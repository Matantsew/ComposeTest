package com.example.comptest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.comptest.R
import com.example.comptest.databinding.MonthViewBinding

class MonthFragment(private val dayOfWeekMonthStarts: Int, private val daysInMonthCount: Int, private val todayDayNumber: Int? = null)
    : Fragment(), CalendarSelectableDayButton.OnDaySelectListener {

    private lateinit var binding: MonthViewBinding

    private lateinit var onActualMonthSetListener: OnActualMonthSetListener

    var month: Int = 0
    var year: Int = 0

    var selectedDay: Int = 0

    var minDateDay: Int = 0

    private var onDateChangeListener: OnDateChangeListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = MonthViewBinding.inflate(layoutInflater)

        renderWeeks()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        onActualMonthSetListener.onSetActualMonth(month, year)
    }

    private fun renderWeeks(){
        (0 until daysInMonthCount).forEach{
            val calendarDay = binding.weeksLayout.findViewById<CalendarSelectableDayButton> (calendarDays[dayOfWeekMonthStarts-1 + it])

            calendarDay.visibility = View.VISIBLE
            calendarDay.dateNumber = it + 1

            if(it + 1 < minDateDay)calendarDay.active = false
            if(it + 1 == todayDayNumber)calendarDay.actualDate = true
            if(it + 1 == selectedDay){
                calendarDay.dateSelected = true
                val selectedDayName = getNameOfDay(dayOfWeekMonthStarts + selectedDay-1)
                onDateChangeListener?.onChangeDate(year, month, selectedDay, selectedDayName)
                onDateChangeListener?.onExchangeDateFragments(this)
            }

            calendarDay.setOnDaySelectListener(this)
        }
    }

    fun setOnActualMonthSetListener(onActualMonthSetListener: OnActualMonthSetListener){
        this.onActualMonthSetListener = onActualMonthSetListener
    }

    fun setOnDateChangeListener(onDateChangeListener: OnDateChangeListener){
        this.onDateChangeListener = onDateChangeListener
    }

    companion object{
        private val calendarDays = arrayOf(
            R.id.w_1_d_1, R.id.w_1_d_2, R.id.w_1_d_3, R.id.w_1_d_4, R.id.w_1_d_5, R.id.w_1_d_6, R.id.w_1_d_7,
            R.id.w_2_d_1, R.id.w_2_d_2, R.id.w_2_d_3, R.id.w_2_d_4, R.id.w_2_d_5, R.id.w_2_d_6, R.id.w_2_d_7,
            R.id.w_3_d_1, R.id.w_3_d_2, R.id.w_3_d_3, R.id.w_3_d_4, R.id.w_3_d_5, R.id.w_3_d_6, R.id.w_3_d_7,
            R.id.w_4_d_1, R.id.w_4_d_2, R.id.w_4_d_3, R.id.w_4_d_4, R.id.w_4_d_5, R.id.w_4_d_6, R.id.w_4_d_7,
            R.id.w_5_d_1, R.id.w_5_d_2, R.id.w_5_d_3, R.id.w_5_d_4, R.id.w_5_d_5, R.id.w_5_d_6, R.id.w_5_d_7,
            R.id.w_6_d_1, R.id.w_6_d_2, R.id.w_6_d_3, R.id.w_6_d_4, R.id.w_6_d_5, R.id.w_6_d_6, R.id.w_6_d_7
        )

        fun getNameOfMonth(index: Int): String {

            return when(index){
                0 -> "Januar"
                1 -> "Februar"
                2 -> "Marz"
                3 -> "April"
                4 -> "Mai"
                5 -> "Juni"
                6 -> "Juli"
                7 -> "August"
                8 -> "September"
                9 -> "Oktober"
                10 -> "November"
                11 -> "Dezember"
                else -> {""}
            }
        }

        fun getNameOfDay(index: Int): String {

            return when(index){
                1,8,15,22,29,36 -> "Montag"
                2,9,16,23,30,37 -> "Dienstag"
                3,10,17,24,31,38 -> "Mittwoch"
                4,11,18,25,32,39 -> "Donnerstag"
                5,12,19,26,33 -> "Freitag"
                6,13,20,27,34 -> "Samstag"
                7,14,21,28,35 -> "Sonntag"
                else -> {""}
            }
        }
    }

    fun invalidatePreviousSelectedDayButton(){
        if(selectedDay != 0) {
            val previousSelectedDayIdIndex = (dayOfWeekMonthStarts - 1) + (selectedDay - 1)
            val previousSelectedDay = binding.weeksLayout.findViewById<CalendarSelectableDayButton>(calendarDays[previousSelectedDayIdIndex])

            previousSelectedDay.dateSelected = false
            previousSelectedDay.invalidate()
        }
    }

    override fun onDaySelect(calendarSelectableDayButton: CalendarSelectableDayButton) {
        if(calendarSelectableDayButton.dateSelected) return
        else calendarSelectableDayButton.dateSelected = true
        calendarSelectableDayButton.invalidate()

        invalidatePreviousSelectedDayButton()

        selectedDay = calendarSelectableDayButton.dateNumber
        val selectedDayName = getNameOfDay(dayOfWeekMonthStarts + selectedDay-1)
        onDateChangeListener?.onChangeDate(year, month, selectedDay, selectedDayName)
        onDateChangeListener?.onExchangeDateFragments(this)
    }

    interface OnDateChangeListener {

        fun onChangeDate(changedYear: Int, changedMonth: Int, changedDayOfMonth: Int, selectedDayName: String)

        fun onExchangeDateFragments(fragmentWhereDateSelected: MonthFragment)
    }

    interface OnActualMonthSetListener{
        fun onSetActualMonth(monthNum: Int, year: Int)
    }
}