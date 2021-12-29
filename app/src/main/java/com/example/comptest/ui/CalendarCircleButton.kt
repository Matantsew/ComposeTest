package com.example.comptest.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.example.comptest.R
import kotlin.math.min

abstract class CalendarCircleButton @JvmOverloads constructor(context: Context,
                                                              attrs: AttributeSet? = null,
                                                              defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    // onSizeChanged(), onDraw(), invalidate()

    private var radius = 0.0f                   // Radius of the circle.

    open lateinit var paintCircle: Paint

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 18.0f
        typeface = Typeface.create( "", Typeface.NORMAL)
        color = Color.BLACK
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeigth: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeigth)

        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paintCircle.color = resources.getColor(R.color.colorAccent)
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paintCircle)
        canvas.drawText("30", (width / 2).toFloat(), ((height + 11.0) / 2).toFloat(), paintText)
    }
}