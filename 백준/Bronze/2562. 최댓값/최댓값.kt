fun main() {
    val numbers = List(9) { readLine()!!.toInt() }
    val maxValue = numbers.maxOf { it }
    val maxIndex = numbers.indexOf(maxValue) + 1

    println(maxValue)
    println(maxIndex)
}