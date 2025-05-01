fun main() {
    val n = readLine()!!.toInt()
    val original = IntArray(n) { readLine()!!.toInt() }
    val sorted = original.sorted()
    val indexMap = IntArray(1_000_001) { -1 }

    for (i in sorted.indices) {
        indexMap[sorted[i]] = i
    }

    val visited = BooleanArray(n)
    val globalMin = sorted[0]
    var answer = 0

    for (i in 0 until n) {
        if (visited[i]) continue

        var cycleSum = 0
        var minInCycle = Int.MAX_VALUE
        var cycleSize = 0
        var j = i

        while (!visited[j]) {
            visited[j] = true
            val weight = original[j]
            minInCycle = minOf(minInCycle, weight)
            cycleSum += weight
            j = indexMap[weight]
            cycleSize++
        }

        if (cycleSize > 1) {
            val method1 = cycleSum + (cycleSize - 2) * minInCycle
            val method2 = cycleSum + minInCycle + (cycleSize + 1) * globalMin
            answer += minOf(method1, method2)
        }
    }

    println(answer)
}
