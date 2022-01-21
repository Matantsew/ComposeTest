package com.example.comptest.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.min
import androidx.core.graphics.drawable.toBitmap
import com.example.comptest.R


class CalendarNavigationButton @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){

    // onSizeChanged(), onDraw(), invalidate()

    var radius = 0.0f                   // Radius of the circle.

    private val imageReference: Int
    private val bitmap: Bitmap

    init{
        isClickable = true

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CalendarNavigationButton)

        try {
            imageReference = attributes.getResourceId(R.styleable.CalendarNavigationButton_imageRef, 0)
        }
        finally {
            attributes.recycle()
        }

        bitmap = createBitmap()
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeigth: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeigth)

        radius = (min(width, height) / 2.0 * 0.8).toFloat()
    }

    private var paintCircle = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(R.color.colorGrey, resources.newTheme())
        strokeWidth = 1f
        style = Paint.Style.STROKE
    }

    private val paintBitmap = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isFilterBitmap = true
        isDither = true
        strokeWidth = 11f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(
            (width / 2).toFloat(),
            (height / 2).toFloat(),
            radius,
            paintCircle
        )

        canvas.drawBitmap(
            bitmap,
            11f,
            11f,
            paintBitmap)
    }

    private fun createBitmap(): Bitmap {

        return resources.getDrawable(imageReference, resources.newTheme())
            .toBitmap(40, 40, Bitmap.Config.ARGB_8888)
    }

}