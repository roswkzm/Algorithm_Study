fun main() {
    val n = readLine()!!.toInt()
    val times = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val totalTime = IntArray(n + 1)

    for (i in 1..n) {
        totalTime[i] = totalTime[i - 1] + times[i - 1]
    }
    println(totalTime.sumOf { it })
}