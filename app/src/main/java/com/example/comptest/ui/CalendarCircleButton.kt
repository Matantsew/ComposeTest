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

    var radius = 0.0f                   // Radius of the circle.

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeigth: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeigth)

        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }
}