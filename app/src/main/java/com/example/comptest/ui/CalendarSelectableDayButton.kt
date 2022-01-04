package com.example.comptest.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import com.example.comptest.R

class CalendarSelectableDayButton @JvmOverloads constructor(context: Context,
                                                            attrs: AttributeSet? = null,
                                                            defStyleAttr: Int = 0
) : CalendarCircleButton(context, attrs, defStyleAttr){

    var actualDate: Boolean
    var dateSelected: Boolean
    var isWeekend: Boolean
    var dateNumber: Int

    private var onDaySelectListener: OnDaySelectListener? = null

    init{
        isClickable = true

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CalendarSelectableDayButton)

        try {
            actualDate = attributes.getBoolean(R.styleable.CalendarSelectableDayButton_actualDate, false)
            dateSelected = attributes.getBoolean(R.styleable.CalendarSelectableDayButton_dateSelected, false)
            dateNumber = attributes.getInt(R.styleable.CalendarSelectableDayButton_dateNumber, 0)
            isWeekend = attributes.getBoolean(R.styleable.CalendarSelectableDayButton_isWeekend, false)
        }
        finally {
            attributes.recycle()
        }
    }

    private var paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(R.color.colorAccent, resources.newTheme())
        strokeWidth = 1f
    }

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 24.0f
        typeface = Typeface.create( "", Typeface.NORMAL)
    }

    fun setOnDaySelectListener(onDaySelectListener: OnDaySelectListener){
        this.onDaySelectListener = onDaySelectListener
    }

    override fun performClick(): Boolean {
        if(super.performClick())return true

        onDaySelectListener?.onDaySelect(this)

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if(actualDate || dateSelected) {

            if(actualDate)paintCircle.style = Paint.Style.STROKE

            if(dateSelected)paintCircle.style = Paint.Style.FILL

            canvas.drawCircle(
                ((width ) / 2).toFloat(),
                ((height ) / 2).toFloat(),
                radius,
                paintCircle
            )
        }

        if(isWeekend && dateSelected)setTextColor(Color.BLACK)
        else if(isWeekend) setTextColor(resources.getColor(R.color.colorAccent, resources.newTheme()))
        else setTextColor(Color.BLACK)

        canvas.drawText(
            dateNumber.toString(),
            (width / 2).toFloat(),
            ((height + 17) / 2).toFloat(),
            paintText)
    }

    private fun setTextColor(color: Int){
        paintText.color = color
    }

    interface OnDaySelectListener {
        fun onDaySelect(calendarSelectableDayButton: CalendarSelectableDayButton)
    }
}