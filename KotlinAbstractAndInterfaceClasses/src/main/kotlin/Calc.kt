class Calc {
    companion object {
        private const val PI = 3.14         //����������� java ������� ��������� �������� final static
        fun square(num: Int) = num * num
        fun lengthOfCircle(radius: Float) = 2 * PI * radius
    }
}