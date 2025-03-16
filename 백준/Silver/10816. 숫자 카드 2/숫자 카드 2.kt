fun main() {
    val n = readLine()!!.toInt()
    val cardMap = mutableMapOf<Int, Int>()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    numbers.forEach {
        cardMap[it] = cardMap.getOrDefault(it, 0) + 1
    }

    val m = readLine()!!.toInt()
    val result = readLine()!!.split(" ").map { cardMap.getOrDefault(it.toInt(), 0) }
    println(result.joinToString(" "))
}