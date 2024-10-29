class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        if (x == y) return 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = mutableSetOf(x)
        queue.add(x to 0)

        while (queue.isNotEmpty()) {
            val (value, steps) = queue.removeFirst()

            val nextValue = listOf(value + n, value * 2, value * 3)
            for (next in nextValue) {
                if (next == y) {
                    return steps + 1
                }
                if (next < y && next !in visited) {
                    visited.add(next)
                    queue.add(next to steps + 1)
                }
            }
        }
        return -1
    }
}