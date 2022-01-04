package com.example.comptest.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.comptest.R
import kotlin.math.min

class CalendarNavigationButton @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    private val imageReference: Int

    init{
        isClickable = true

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CalendarNavigationButton)

        try {
            imageReference = attributes.getResourceId(R.styleable.CalendarNavigationButton_imageRef, 0)
        }
        finally {
            attributes.recycle()
        }
    }

    // onSizeChanged(), onDraw(), invalidate()

    var radius = 0.0f                   // Radius of the circle.

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeigth: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeigth)

        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }


    private var paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(R.color.colorGrey, resources.newTheme())
        strokeWidth = 1f
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            radius,
            paintCircle
        )
    }

}