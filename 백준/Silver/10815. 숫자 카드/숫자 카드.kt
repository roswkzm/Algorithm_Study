fun main() {
    val n = readLine()!!.toInt()
    val cards = readLine()!!.split(" ").map { it.toInt() }.toSet()
    val m = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }

    val result = numbers.map { if (it in cards) "1" else "0" }.joinToString(" ")
    println(result)
}