package com.techapp.james.drawview

import android.graphics.Canvas
import android.graphics.Paint

class Points {
    val collection = ArrayList<Point>()
    fun draw(canvas: Canvas, paint: Paint) {
        collection.forEach { e ->
            canvas.drawPoint(e.x, e.y, paint)
        }
    }

    fun add(point: Point) {
        collection.add(point)
    }

    fun eraser(point: Point) {
        collection.remove(point)
    }
}