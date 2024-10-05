class Solution {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") {
            it.mapIndexed { index, c -> if (index == 0) c.uppercase() else c.lowercase() }
                .joinToString("")
        }
    }
}