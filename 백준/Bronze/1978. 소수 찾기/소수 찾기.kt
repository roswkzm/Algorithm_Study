import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    var result = 0
    val numbers = readLine()!!.split(" ").map { it.toInt() }

    numbers.forEach {
        if (isPrime(it)) result++
    }
    println(result)
}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}