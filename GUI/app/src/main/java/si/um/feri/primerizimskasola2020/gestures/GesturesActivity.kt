package si.um.feri.primerizimskasola2020.gestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import si.um.feri.primerizimskasola2020.R

private const val DEBUG_TAG = "Gestures"

class GesturesActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestures)

        mDetector = GestureDetectorCompat(this, this)

        mDetector.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDown: $event")
        Toast.makeText(this, "onDown: $event", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onFling(
        event1: MotionEvent,
        event2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onFling: $event1 $event2")
        Toast.makeText(this, "onFling: $event1 $event2", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onLongPress: $event")
        Toast.makeText(this, "onFling: $event", Toast.LENGTH_SHORT).show()
    }

    override fun onScroll(
        event1: MotionEvent,
        event2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(DEBUG_TAG, "onScroll: $event1 $event2")
        Toast.makeText(this, "onScroll: $event1 $event2", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        Log.d(DEBUG_TAG, "onShowPress: $event")
        Toast.makeText(this, "onShowPress: $event", Toast.LENGTH_SHORT).show()
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapUp: $event")
        Toast.makeText(this, "onSingleTapUp: $event", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTap: $event")
        Toast.makeText(this, "onDoubleTap: $event", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: $event")
        Toast.makeText(this, "onDoubleTapEvent: $event", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: $event")
        Toast.makeText(this, "onSingleTapConfirmed: $event", Toast.LENGTH_SHORT).show()
        return true
    }
}
