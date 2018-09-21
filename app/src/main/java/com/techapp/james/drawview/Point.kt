package com.techapp.james.drawview

data class Point(var x: Float, var y: Float) {
    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return other.x.toString().equals(x.toString()) &&
                    other.y.toString().equals(y.toString())
        }
        return super.equals(other)
    }
}
