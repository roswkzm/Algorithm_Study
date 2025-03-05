fun main() {
    val n = readLine()!!.toInt()

    for (i in 1..n) {
        println(" ".repeat(n - i) + "*".repeat(2 * i - 1))
    }

    for (i in n - 1 downTo 1) {
        println(" ".repeat(n - i) + "*".repeat(2 * i - 1))
    }
}
