fun main() {
    val n = readLine()!!.toInt()
    val meetings = List(n) {
        val (start, end) = readLine()!!.split(" ").map { it.toInt() }
        start to end
    }
    val sorted = meetings.sortedWith(compareBy({ it.second }, { it.first }))

    var count = 0
    var lastEndTime = 0

    for ((start, end) in sorted) {
        if (start >= lastEndTime) {
            count++
            lastEndTime = end
        }
    }

    println(count)
}