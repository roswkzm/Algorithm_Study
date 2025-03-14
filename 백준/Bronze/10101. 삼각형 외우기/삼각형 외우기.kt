fun main() {
    val (a, b, c) = IntArray(3) { readLine()!!.toInt() }

    if (a + b + c != 180) {
        println("Error")
    } else if (a == b && b == c) {
        println("Equilateral")
    } else if (a == b || b == c || a == c) {
        println("Isosceles")
    } else {
        println("Scalene")
    }
}