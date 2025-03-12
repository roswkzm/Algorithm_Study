fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val (c, d) = readLine()!!.split(" ").map { it.toInt() }

    println("${minOf(a + d, b + c)}")
}
