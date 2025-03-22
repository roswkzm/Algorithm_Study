fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    println(factorial(n) / (factorial(k) * factorial(n - k)))
}

fun factorial(n: Int): Int {
    var result = 1
    for (i in 2..n) result *= i
    return result
}