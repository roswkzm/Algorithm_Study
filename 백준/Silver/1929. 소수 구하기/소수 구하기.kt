import kotlin.math.sqrt

fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }

    for (num in m..n) {
        if (isPrime(num)) println(num)
    }
}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    val sqrtN = sqrt(n.toDouble()).toInt()
    for (i in 5..sqrtN step 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false
    }
    return true
}