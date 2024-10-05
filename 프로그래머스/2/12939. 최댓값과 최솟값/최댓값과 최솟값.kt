class Solution {
    fun solution(s: String): String {
        val intList = s.split(" ").map { it.toInt() }
        return "${intList.minOf { it }} ${intList.maxOf { it }}"
    }
}