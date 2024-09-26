class Solution {
    fun solution(s: String): IntArray {
        var answer = arrayListOf<Int>()
        var addStringTemp = arrayListOf<Char>()

        for ((index, char) in s.withIndex()) {
            val charIndex = addStringTemp.indexOfLast { it == char }

            if (charIndex == -1){
                answer.add(charIndex)
            } else {
                answer.add(index - charIndex)
            }
            addStringTemp.add(char)
        }

        return answer.toIntArray()
    }
}