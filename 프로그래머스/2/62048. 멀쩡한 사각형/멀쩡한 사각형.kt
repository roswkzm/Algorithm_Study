class Solution {
    fun solution(W: Int, H: Int): Long {
        val g = gcd(W, H)
        val totalSquares = W.toLong() * H
        val unusableSquares = W.toLong() + H - g
        return totalSquares - unusableSquares
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}