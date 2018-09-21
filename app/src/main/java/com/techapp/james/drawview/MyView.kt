package com.techapp.james.drawview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import org.json.JSONObject

class MyView : View {
    private val drawTool = DrawTool()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    var flag = true
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRGB(255, 0, 255)
        canvas?.drawColor(Color.TRANSPARENT)
        // draw circle
        var paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 10f
        paint.isAntiAlias = true // 抗鋸齒
//        canvas?.drawCircle(200f, 200f, 150f, paint)


        drawTool.draw(canvas!!, paint)

        //draw line
        paint.color = Color.GREEN
//        canvas?.drawLine(100f, 100f, 200f, 200f, paint)


        //muti line
        paint.color = Color.BLACK
        var pts = floatArrayOf(300f, 300f, 400f, 400f, 500f, 500f, 600f, 600f)
        // offset(0): skip 0 data ( not point )
        // count (8): data which is in draw process actually
//        canvas?.drawLines(pts, 0, 8, paint)

        //draw point
        paint.color = Color.BLUE
        canvas?.drawPoint(700f, 700f, paint)

        //draw muti point
        paint.color = Color.LTGRAY
        var points = floatArrayOf(600f, 600f, 900f, 900f, 500f, 500f, 600f, 600f)
        //offset(0): same as muti line
        //count(8): same as muti line
//        canvas?.drawPoints(points, 0, 8, paint)


        //Rect RectF is same but RectF store float type
        paint.color = Color.BLACK
        //set Rect
//        var rect = Rect(10, 10, 100, 100)
        var rect = Rect()
        rect.set(10, 10, 700, 700)
        //draw rect
//        canvas?.drawRect(rect, paint)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        invalidate()

        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                drawTool.setPoint(com.techapp.james.drawview.Point(event.x, event.y))
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("Move ", " ${event.x} ${event.y}")
                drawTool.setPoint(com.techapp.james.drawview.Point(event.x, event.y))
                invalidate()
            }
        }
        return true
    }
}