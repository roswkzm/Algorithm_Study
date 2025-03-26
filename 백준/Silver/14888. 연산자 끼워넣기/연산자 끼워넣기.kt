var max = Int.MIN_VALUE
var min = Int.MAX_VALUE

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val operators = readLine()!!.split(" ").map { it.toInt() }.toIntArray() // + - * /

    dfs(1, numbers[0], numbers, operators)

    println(max)
    println(min)
}

fun dfs(index: Int, current: Int, numbers: List<Int>, ops: IntArray) {
    if (index == numbers.size) {
        max = maxOf(max, current)
        min = minOf(min, current)
        return
    }

    for (i in 0..3) {
        if (ops[i] > 0) {
            ops[i]--

            val next = when (i) {
                0 -> current + numbers[index]
                1 -> current - numbers[index]
                2 -> current * numbers[index]
                3 -> current / numbers[index]
                else -> current
            }

            dfs(index + 1, next, numbers, ops)

            ops[i]++
        }
    }
}