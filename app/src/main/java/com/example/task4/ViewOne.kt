package com.example.task4

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import com.google.android.material.snackbar.Snackbar

class ViewOne: View {
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

    init {
        // 'this' is a reference to the current class.
        // Views have many properties - one is backgroundColor.
        this.setBackgroundColor(Color.argb(128,32,64,255))
    }

    //Detecting touch but then passing to geature method for identification
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return myGestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
    }

    private inner class MyGestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onDoubleTap(e: MotionEvent): Boolean {
            // You can access the properties of the event
            val xCoord = e.x
            val yCoord = e.y

            Log.d(LOGTAG, "DoubleTapUp x= $xCoord y= $yCoord")
            return true
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val xCoord = e1.x
            val yCoord = e2.y

            Log.d(LOGTAG, "Fling x= $xCoord y= $yCoord vX= $velocityX  vY=$velocityY")
            return true
        }

        override fun onDown(ev: MotionEvent): Boolean {
            /*
             * You should always include onDown().
             *
             * Normally onDown should return true, unless you want to ignore all touch gestures
             * starting in a particular region of your view (you will not see events from outside
             * the view anyway).
             */
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            // You can access the properties of the event
            val xCoord = e.x
            val yCoord = e.y

            Log.d(LOGTAG, "SingleTapUp x= $xCoord y= $yCoord")

            //Snackbar should display, Snackbars address some of the limitations of Toasts (including queueing),
            // but are mainly a good way for displaying information temporarily. They also allow some advanced capabilities with more configuration.
            //FORMAT Snackbar.make(context, textString, displayTime).show()

            Snackbar
                .make(this@ViewOne, "SingleTapUp x= $xCoord y= $yCoord", Snackbar.LENGTH_SHORT)
                .show()

            return true
        }

        /* better to use confrim single tap when using DOUBLE and SINGLE to insure the single tap isnt the start of a double
        override fun onSingleTapUp(ev: MotionEvent): Boolean {
            // You can access the properties of the event
            val xCoord = ev.x
            val yCoord = ev.y

            Log.d(LOGTAG, "SingleTapUp x= $xCoord y= $yCoord")
            return true
        }

         */

    }  // End of myGestureListener class


    companion object {         // declare a constant (must be in the companion of the outer class)
        const val LOGTAG = "MyTask"
    }




}



//EX CODE
/*
 //Same no matter what touch the same response not right
 //Returns True if the listener has consumed the event, false otherwise.
 override fun onTouchEvent(event: MotionEvent): Boolean {

     val DEBUG_TAG = "MyTask"

     val action: Int = event.actionMasked

         // to see what data a touch event consists of
     val eventString = event.toString()
     Log.d(DEBUG_TAG, eventString)
         //
     when (action) {
         MotionEvent.ACTION_DOWN -> {
             Log.d(DEBUG_TAG, "Action was DOWN")
             return true
         }
         MotionEvent.ACTION_MOVE -> {
             Log.d(DEBUG_TAG, "Action was MOVE")
             return true
         }
         MotionEvent.ACTION_UP -> {
             Log.d(DEBUG_TAG, "Action was UP")
             return true
         }
         MotionEvent.ACTION_CANCEL -> {
             Log.d(DEBUG_TAG, "Action was CANCEL")
             return true
         }
         MotionEvent.ACTION_OUTSIDE -> {
             Log.d(DEBUG_TAG, "Outside bounds of current screen element")
             return true
         }
         else -> return super.onTouchEvent(event)
     }
 }

  */