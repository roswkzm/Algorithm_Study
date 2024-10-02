class Solution {
    fun solution(s: String): String {
        return s.split(" ")
            .map {
                it.mapIndexed { index, c -> if (index % 2 == 0) c.uppercase() else c.lowercase() }
            }.joinToString(" ") { it.joinToString("") }
    }
}