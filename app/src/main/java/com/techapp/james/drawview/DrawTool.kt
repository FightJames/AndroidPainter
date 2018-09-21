package com.techapp.james.drawview

import android.graphics.Canvas
import android.graphics.Paint

class DrawTool {
    var mode = Mode.PAINT
    lateinit var points: Points

    constructor() {
        points = Points()
    }

    constructor(points: Points) {
        this.points = points
    }

    enum class Mode {
        PAINT, ERASER
    }

    fun setPoint(point: Point) {
        if (mode == Mode.PAINT) {
            points.add(point)
        } else {
            points.eraser(point)
        }
    }

    fun draw(canvas: Canvas, paint: Paint) {
        points.draw(canvas, paint)
    }

}