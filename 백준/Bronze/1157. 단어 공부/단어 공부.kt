fun main() {
    val input = readLine()!!.uppercase()
    val frequency = input.groupingBy { it }.eachCount()
    val maxCount = frequency.values.maxOrNull()!!
    val mostFrequent = frequency.filter { it.value == maxCount }.keys

    println(if (mostFrequent.size > 1) "?" else mostFrequent.first())
}
