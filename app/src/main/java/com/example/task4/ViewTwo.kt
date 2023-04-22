package com.example.task4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class ViewTwo: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private val myGestureDetector = GestureDetectorCompat(context, MyGestureListener())

    private val backCol: Int = Color.rgb(250,250,200)
    private var OnePaint: Paint

    private val TwoCol: Int = Color.rgb(250,50,20)
    private var TwoPaint: Paint

    private val ThreeCol: Int = Color.rgb(50,250,20)
    private var ThreePaint: Paint

    init {
        // 'this' is a reference to the current class.
        // Views have many properties - one is backgroundColor.
        this.setBackgroundColor(Color.argb(128,32,64,255))

        OnePaint = Paint().apply {
            // Set up the paint style
            setStyle(Paint.Style.FILL)
            setColor(backCol)
        }

        TwoPaint = Paint().apply {
            // Set up the paint style
            setStyle(Paint.Style.FILL)
            setColor(TwoCol)
        }

        ThreePaint = Paint().apply {
            // Set up the paint style
            setStyle(Paint.Style.FILL)
            setColor(ThreeCol)
        }
    }

    override fun onDraw(canvas: Canvas) {
        // Background
        // Measure the size of the canvas, we could take into account padding here
        val canvasWidth = (width.toFloat()) / 2
        val canvasHeight = (height.toFloat()) / 2

        // Draw rectangle with drawRect(topleftX, topLeftY, bottomRightX, bottomRightY, Paint)
        // Use Ctrl-P to see the parameters for a function
        canvas.drawRect(0f, 0f, canvasWidth, canvasHeight, OnePaint)
        canvas.drawRect(0f,0f,(canvasWidth*2), canvasHeight,  TwoPaint)
        canvas.drawRect(0f, 0f,canvasWidth, canvasHeight, ThreePaint)

    }


    //Detecting touch but then passing to geature method for identification
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return myGestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    private inner class MyGestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }


    }


}