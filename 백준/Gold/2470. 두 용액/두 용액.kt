import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }.sorted()

    var left = 0
    var right = n - 1
    var diffValue = Int.MAX_VALUE
    var result = 0 to 0

    while (left < right) {
        val sum = nums[left] + nums[right]
        val absSum = abs(sum)
        if (absSum < diffValue) {
            diffValue = absSum
            result = left to right
        }

        if (sum < 0) left++
        else right--
    }
    println("${nums[result.first]} ${nums[result.second]}")
}