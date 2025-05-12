import kotlin.math.*

fun main() {
    val n = readLine()!!.toInt()
    val nums = readLine()!!.split(" ").map { it.toInt() }
    val ops = readLine()!!.split(" ").map { it.toInt() } // + - * /
    var maxResult = Int.MIN_VALUE
    var minResult = Int.MAX_VALUE

    fun dfs(depth: Int, current: Int, add: Int, sub: Int, mul: Int, div: Int) {
        if (depth == n) {
            maxResult = max(maxResult, current)
            minResult = min(minResult, current)
            return
        }

        val next = nums[depth]

        if (add > 0) dfs(depth + 1, current + next, add - 1, sub, mul, div)
        if (sub > 0) dfs(depth + 1, current - next, add, sub - 1, mul, div)
        if (mul > 0) dfs(depth + 1, current * next, add, sub, mul - 1, div)
        if (div > 0) {
            val result = if (current < 0) -(-current / next) else current / next
            dfs(depth + 1, result, add, sub, mul, div - 1)
        }
    }

    dfs(1, nums[0], ops[0], ops[1], ops[2], ops[3])

    println(maxResult)
    println(minResult)
}
