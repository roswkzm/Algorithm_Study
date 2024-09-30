class Solution {
    fun solution(x: Int): Boolean {
        val sumOfDigits = x.toString().map { it.toString().toInt() }.sum()
        return x % sumOfDigits == 0
    }
}