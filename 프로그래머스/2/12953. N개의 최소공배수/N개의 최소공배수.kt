class Solution {
    fun solution(arr: IntArray): Int {
        return arr.reduce { acc, i -> lcm(acc, i) }
    }

    private fun gcb(a: Int, b: Int): Int {
        return if (b == 0) a else gcb(b, (a % b))
    }

    private fun lcm(a: Int, b: Int): Int {
        return (a * b) / gcb(a, b)
    }
}