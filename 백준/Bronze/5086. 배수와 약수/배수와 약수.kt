fun main() {
    while (true) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        if (a == 0 && b == 0) break
        when {
            b % a == 0 -> println("factor")
            a % b == 0 -> println("multiple")
            else -> println("neither")
        }
    }
}