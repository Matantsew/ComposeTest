package com.example.comptest.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import com.example.comptest.R

class CalendarDayButton @JvmOverloads constructor(context: Context,
                                                  attrs: AttributeSet? = null,
                                                  defStyleAttr: Int = 0
) : CalendarCircleButton(context, attrs, defStyleAttr){

    init{
        isClickable = true
    }

    override fun performClick(): Boolean {
        if(super.performClick())return true



        invalidate()
        return true
    }

    override var paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1f
    }

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 18.0f
        typeface = Typeface.create( "", Typeface.NORMAL)
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paintCircle.color = resources.getColor(R.color.colorAccent)
        canvas.drawText("30", (width / 2).toFloat(), ((height + 11.0) / 2).toFloat(), paintText)
    }
}