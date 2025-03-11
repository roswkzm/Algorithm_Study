import kotlin.math.pow

fun main() {
    var currPosition = 0 to 0
    var score = 0L
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val visibleTargets = mutableListOf<Pair<Int, Int>>()
    val hiddenTargets = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        visibleTargets.add(a to b)
    }

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        hiddenTargets.add(a to b)
    }

    repeat(m) {
        val farthestTarget = visibleTargets.maxByOrNull { distanceSquared(currPosition, it) }!!
        score += distanceSquared(currPosition, farthestTarget)
        currPosition = farthestTarget
        visibleTargets.remove(farthestTarget)
        if (hiddenTargets.isNotEmpty()) {
            visibleTargets.add(hiddenTargets.removeAt(0))
        }
    }
    println(score)
}

fun distanceSquared(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Long {
    return ((p1.first - p2.first).toDouble().pow(2) + (p1.second - p2.second).toDouble().pow(2)).toLong()
}