fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val rows = List(n) { readLine()!! }
    val k = readLine()!!.toInt()

    val countMap = mutableMapOf<String, Int>()

    for (row in rows) {
        countMap[row] = countMap.getOrDefault(row, 0) + 1
    }

    var max = 0

    for ((pattern, count) in countMap) {
        val zeroCount = pattern.count { it == '0' }
        if (zeroCount <= k && (k - zeroCount) % 2 == 0) {
            max = maxOf(max, count)
        }
    }

    println(max)
}
