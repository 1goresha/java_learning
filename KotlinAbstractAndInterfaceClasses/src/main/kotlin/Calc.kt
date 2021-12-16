class Calc {
    companion object {
        private const val PI = 3.14         //равносильно java способу написания констант final static
        fun square(num: Int) = num * num
        fun lengthOfCircle(radius: Float) = 2 * PI * radius
    }
}