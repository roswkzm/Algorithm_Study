fun main() {
    while (true) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) break
        if (maxOf(a, b, c) >= (a + b + c) - maxOf(a, b, c)) {
            println("Invalid")
            continue
        }
        if (a == b && b == c) {
            println("Equilateral")
        } else if (a == b || b == c || a == c) {
            println("Isosceles")
        } else {
            println("Scalene")
        }
    }
}