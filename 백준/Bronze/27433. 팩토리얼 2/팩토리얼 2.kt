fun main() {
    val n = readLine()!!.toInt()
    println(factorial(n))
}

fun factorial(n: Int): Long {
    if (n <= 1) return 1
    return n * factorial(n - 1)
}