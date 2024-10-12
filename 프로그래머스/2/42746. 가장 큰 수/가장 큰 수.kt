class Solution {
    fun solution(numbers: IntArray): String {
        val result = numbers.sortedWith { a, b ->
            val aPlusB = "$a$b".toInt()
            val bPlusA = "$b$a".toInt()
            bPlusA.compareTo(aPlusB)
        }.joinToString("")
        return if (result.all { it == '0' }) "0" else result
    }
}