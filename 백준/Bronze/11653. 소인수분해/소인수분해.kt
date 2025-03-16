import kotlin.math.sqrt

fun main() {
    var n = readLine()!!.toInt()

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        while (n % i == 0) {
            println(i)
            n /= i
        }
    }

    if (n > 1) {
        println(n)
    }
}