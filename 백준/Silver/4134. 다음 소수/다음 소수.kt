import kotlin.math.sqrt

fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) { readLine()!!.toLong() }
    list.forEach {
        var n = it
        while (!isPrime(n)) {
            n++
        }
        println(n)
    }
}

fun isPrime(n: Long): Boolean {
    if (n < 2) return false
    if (n == 2L || n == 3L) return true
    if (n % 2 == 0L || n % 3 == 0L) return false
    val sqrtNum = sqrt(n.toDouble()).toLong()
    for (i in 5..sqrtNum step 2) {
        if (n % i == 0L) return false
    }
    return true
}