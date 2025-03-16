import kotlin.math.sqrt

fun main() {
    while (true) {
        val n = readLine()!!.toInt()
        val list = mutableListOf<Int>()
        if (n == -1) break
        for (i in 1..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                list.add(i)
                if (i != n / i && n != n / i) {
                    list.add(n / i)
                }
            }
        }
        list.sort()
        if (list.sumOf { it } == n) {
            println("$n = ${list.joinToString(" + ")}")
        } else {
            println("$n is NOT perfect.")
        }
    }
}