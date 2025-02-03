class Solution {
    fun solution(s: String): String {
        val sortedList = s.split(" ").map{ it.toInt() }.sorted()
        return "${sortedList.first()} ${sortedList.last()}"
    }
}