import kotlin.math.sqrt

fun main() {
    val m = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val list = mutableListOf<Int>()

    for (i in m..n) {
        if (isPrime(i)) list.add(i)
    }

    if (list.isEmpty()) {
        println(-1)
    } else {
        println(list.sum())
        println(list.minOf { it })
    }
}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false

    val sqrtN = sqrt(n.toDouble()).toInt()
    for (i in 5..sqrtN step 2) {
        if (n % i == 0) return false
    }
    return true
}