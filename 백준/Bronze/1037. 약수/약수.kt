fun main() {
    val t = readLine()!!.toInt()
    val divisors = readLine()!!.split(" ").map { it.toInt() }

    val min = divisors.minOf { it }
    val max = divisors.maxOf { it }

    println(min * max)
}