import kotlin.math.roundToInt

fun main() {
    val n = readLine()!!.toInt()
    val nums = Array(n) { readLine()!!.toInt() }

    println((nums.sum().toDouble() / n).roundToInt())
    println(nums.sorted()[n / 2])
    println(
        nums.groupBy { it }.mapValues { it.value.size }.toList()
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .let { if (it.size > 1 && it[0].second == it[1].second) it[1].first else it[0].first }
    )
    println(nums.maxOf { it } - nums.minOf { it })
}