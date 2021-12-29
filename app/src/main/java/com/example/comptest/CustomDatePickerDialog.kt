package com.example.comptest

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.comptest.databinding.DialogCustomDatePickerBinding
import com.example.comptest.ui.CalendarDayButton
import java.text.SimpleDateFormat
import java.util.*

class CustomDatePickerDialog(context: Context, listener: DatePickerDialog.OnDateSetListener?,
                             private val year: Int, private val month: Int, private val dayOfMonth: Int)
    : AlertDialog(context), DialogInterface.OnClickListener, CalendarView.OnDateChangeListener{

    private var calendarDays = arrayOf(
        R.id.w_1_d_1, R.id.w_1_d_2, R.id.w_1_d_3, R.id.w_1_d_4, R.id.w_1_d_5, R.id.w_1_d_6, R.id.w_1_d_7,
        R.id.w_2_d_1, R.id.w_2_d_2, R.id.w_2_d_3, R.id.w_2_d_4, R.id.w_2_d_5, R.id.w_2_d_6, R.id.w_2_d_7,
        R.id.w_3_d_1, R.id.w_3_d_2, R.id.w_3_d_3, R.id.w_3_d_4, R.id.w_3_d_5, R.id.w_3_d_6, R.id.w_3_d_7,
        R.id.w_4_d_1, R.id.w_4_d_2, R.id.w_4_d_3, R.id.w_4_d_4, R.id.w_4_d_5, R.id.w_4_d_6, R.id.w_4_d_7,
        R.id.w_5_d_1, R.id.w_5_d_2, R.id.w_5_d_3, R.id.w_5_d_4, R.id.w_5_d_5, R.id.w_5_d_6, R.id.w_5_d_7,
        R.id.w_6_d_1, R.id.w_6_d_2, R.id.w_6_d_3, R.id.w_6_d_4, R.id.w_6_d_5, R.id.w_6_d_6, R.id.w_6_d_7
    )

    private lateinit var binding: DialogCustomDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCustomDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val monthStartsAtDay = calendar.firstDayOfFirstWeek()

        binding.weeksViewRecycler.adapter = CalendarAdapter()
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

    class CalendarAdapter(private val dataSet: Array<Int>, dayOfWeekStarts: Int) :
        RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val weeksLayout: LinearLayout

            init {
                // Define click listener for the ViewHolder's View.
                weeksLayout = view.findViewById(R.id.weeks_layout)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.weeks_view, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.weeksLayout.findViewById<CalendarDayButton>(R.id.w_1_d_1)// dataSet[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }

}